package com.yx.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yx start
 * @create 2020/4/19,10:04
 */
@Configuration
public class RestConfiguration {
    /**
     * 构建远程方法调用
     * @return
     */
    @Bean
    @LoadBalanced // 开启负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
