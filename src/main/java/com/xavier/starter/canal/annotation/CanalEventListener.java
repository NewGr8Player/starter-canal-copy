package com.xavier.starter.canal.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * inject the present class to the spring context
 * as a listener of the canal event
 *
 * @author NewGr8Player
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface CanalEventListener {

	@AliasFor(annotation = Component.class)
	String value() default "";

}
