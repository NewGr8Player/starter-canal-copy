package com.xavier.starter.canal.client;

import com.alibaba.otter.canal.client.CanalConnector;
import com.xavier.starter.canal.annotation.CanalEventListener;
import com.xavier.starter.canal.util.BeanUtil;
import com.xavier.starter.canal.annotation.ListenPoint;
import com.xavier.starter.canal.client.transfer.TransponderFactory;
import com.xavier.starter.canal.config.CanalConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * SimpleCanalClient
 * use cache thread pool to handle the event
 *
 * @author NewGr8Player
 */
@Slf4j
public class SimpleCanalClient extends AbstractCanalClient {

    /**
     * executor
     */
    private ThreadPoolExecutor executor;

    /**
     * listeners which are used by implementing the Interface
     */
    private final List<com.xavier.starter.canal.event.CanalEventListener> listeners = new ArrayList<>();

    /**
     * listeners which are used by annotation
     */
    private final List<ListenerPoint> annoListeners = new ArrayList<>();

    public SimpleCanalClient(CanalConfig canalConfig, TransponderFactory factory) {
        super(canalConfig, factory);
        executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<>(), Executors.defaultThreadFactory());
        initListeners();
    }

    @Override
    protected void process(CanalConnector connector, Map.Entry<String, CanalConfig.Instance> config) {
        executor.submit(factory.newTransponder(connector, config, listeners, annoListeners));
    }

    @Override
    public void stop() {
        super.stop();
        executor.shutdown();
    }

    /**
     * init listeners
     */
    private void initListeners() {
        log.info("{}: initializing the listeners....", Thread.currentThread().getName());
        List<com.xavier.starter.canal.event.CanalEventListener> list = BeanUtil.getBeansOfType(com.xavier.starter.canal.event.CanalEventListener.class);
        if (list != null) {
            listeners.addAll(list);
        }
        Map<String, Object> listenerMap = BeanUtil.getBeansWithAnnotation(CanalEventListener.class);
        if (listenerMap != null) {
            for (Object target : listenerMap.values()) {
                Method[] methods = target.getClass().getDeclaredMethods();
                if (methods != null && methods.length > 0) {
                    for (Method method : methods) {
                        ListenPoint l = AnnotationUtils.findAnnotation(method, ListenPoint.class);
                        if (l != null) {
                            annoListeners.add(new ListenerPoint(target, method, l));
                        }
                    }
                }
            }
        }
        log.info("{}: initializing the listeners end.", Thread.currentThread().getName());
        if (log.isWarnEnabled() && listeners.isEmpty() && annoListeners.isEmpty()) {
            log.warn("{}: No listener found in context! ", Thread.currentThread().getName());
        }
    }
}
