package com.xavier.starter.canal.config;


import com.xavier.starter.canal.client.CanalClient;
import com.xavier.starter.canal.client.SimpleCanalClient;
import com.xavier.starter.canal.client.transfer.MessageTransponders;
import com.xavier.starter.canal.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;


/**
 * CanalClientConfiguration
 *
 * @author NewGr8Player
 */
@Slf4j
public class CanalClientConfiguration {

	@Autowired
	private CanalConfig canalConfig;

	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public BeanUtil beanUtil() {
		return new BeanUtil();
	}

	@Bean
	private CanalClient canalClient() {
		CanalClient canalClient = new SimpleCanalClient(canalConfig, MessageTransponders.defaultMessageTransponder());
		canalClient.start();
		log.info("Starting canal client....");
		return canalClient;
	}
}
