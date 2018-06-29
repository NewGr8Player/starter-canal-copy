package com.xavier.starter.canal.annotation;

import com.xavier.starter.canal.config.CanalClientConfiguration;
import com.xavier.starter.canal.config.CanalConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Enables the canal client
 *
 * @author chen.qian
 * @date 2018/3/19
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CanalConfig.class, CanalClientConfiguration.class})
public @interface EnableCanalClient {
}
