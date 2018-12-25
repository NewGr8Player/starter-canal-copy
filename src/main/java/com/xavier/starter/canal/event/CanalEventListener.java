package com.xavier.starter.canal.event;

import com.alibaba.otter.canal.protocol.CanalEntry;

/**
 * CanalEventListener
 *
 * @author NewGr8Player
 */
public interface CanalEventListener {

	/**
	 * run when event was fired
	 *
	 * @param tableName tableName
	 * @param eventType eventType
	 * @param entry     entry
	 */
	void onEvent(String tableName, CanalEntry.EventType eventType, CanalEntry.RowData entry);

}
