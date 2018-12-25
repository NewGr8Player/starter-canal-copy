package com.xavier.starter.canal.client.transfer;

/**
 * @author NewGr8Player
 */
public class MessageTransponders {

	public static TransponderFactory defaultMessageTransponder() {
		return new DefaultTransponderFactory();
	}

}
