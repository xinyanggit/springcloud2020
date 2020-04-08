package com.yx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yx start
 * @create 2020/3/29,12:50
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderFeignApplication90 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApplication90.class);
    }
}
