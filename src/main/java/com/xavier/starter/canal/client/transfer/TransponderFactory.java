package com.xavier.starter.canal.client.transfer;

import com.alibaba.otter.canal.client.CanalConnector;
import com.xavier.starter.canal.client.ListenerPoint;
import com.xavier.starter.canal.config.CanalConfig;
import com.xavier.starter.canal.event.CanalEventListener;

import java.util.List;
import java.util.Map;

/**
 * TransponderFactory
 *
 * @author NewGr8Player
 */
public interface TransponderFactory {

	/**
	 * @param connector     connector
	 * @param config        config
	 * @param listeners     listeners
	 * @param annoListeners annoListeners
	 * @return MessageTransponder
	 */
	MessageTransponder newTransponder(CanalConnector connector, Map.Entry<String, CanalConfig.Instance> config, List<CanalEventListener> listeners,
	                                  List<ListenerPoint> annoListeners);
}
