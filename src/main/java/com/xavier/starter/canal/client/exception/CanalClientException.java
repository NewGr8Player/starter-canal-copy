package com.xavier.starter.canal.client.exception;

import lombok.NoArgsConstructor;

/**
 * @author NewGr8Player
 */
@NoArgsConstructor
public class CanalClientException extends RuntimeException {

	public CanalClientException(String message) {
		super(message);
	}

	public CanalClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public CanalClientException(Throwable cause) {
		super(cause);
	}

	public CanalClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
