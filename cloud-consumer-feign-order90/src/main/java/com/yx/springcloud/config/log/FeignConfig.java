package com.yx.springcloud.config.log;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * feign调用等级
 * @author yx start
 * @create 2020/4/8,14:24
 */
@Configuration
public class FeignConfig {
    /**
     * feignClient配置日志级别
     *         NONE,
     *         BASIC,
     *         HEADERS,
     *         FULL;
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        // 请求和响应的头信息,请求和响应的正文及元数据
        return Logger.Level.FULL;
    }
}
