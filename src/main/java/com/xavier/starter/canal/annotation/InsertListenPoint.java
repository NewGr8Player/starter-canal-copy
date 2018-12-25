package com.xavier.starter.canal.annotation;

import com.alibaba.otter.canal.protocol.CanalEntry;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * ListenPoint for insert
 *
 * @author NewGr8Player
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ListenPoint(eventType = CanalEntry.EventType.INSERT)
public @interface InsertListenPoint {

	/**
	 * canal destination
	 * default for all
	 *
	 * @return canal destination
	 */
	@AliasFor(annotation = ListenPoint.class)
	String destination() default "";

	/**
	 * database schema which you are concentrate on
	 * default for all
	 *
	 * @return canal destination
	 */
	@AliasFor(annotation = ListenPoint.class)
	String[] schema() default {};

	/**
	 * tables which you are concentrate on
	 * default for all
	 *
	 * @return canal destination
	 */
	@AliasFor(annotation = ListenPoint.class)
	String[] table() default {};

}
