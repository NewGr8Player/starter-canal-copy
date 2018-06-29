package com.xavier.starter.canal.client.transfer;

import com.alibaba.otter.canal.client.CanalConnector;
import com.xavier.starter.canal.client.ListenerPoint;
import com.xavier.starter.canal.event.CanalEventListener;
import com.xavier.starter.canal.config.CanalConfig;

import java.util.List;
import java.util.Map;

/**
 * @author chen.qian
 * @date 2018/3/23
 */
public class DefaultTransponderFactory implements TransponderFactory {
    @Override
    public MessageTransponder newTransponder(CanalConnector connector, Map.Entry<String, CanalConfig.Instance> config, List<CanalEventListener> listeners,
                                             List<ListenerPoint> annoListeners) {
        return new DefaultMessageTransponder(connector, config, listeners, annoListeners);
    }
}
