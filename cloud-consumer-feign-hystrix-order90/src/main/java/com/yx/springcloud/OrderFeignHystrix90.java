package com.yx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yx start
 * @create 2020/4/8,15:47
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix  // 客户端用@EnableHystrix 。服务提供方用 @EnableCircuitBreaker
public class OrderFeignHystrix90 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrix90.class);
    }
}
