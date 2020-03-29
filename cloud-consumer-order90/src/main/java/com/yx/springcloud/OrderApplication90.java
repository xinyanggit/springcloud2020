package com.yx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yx start
 * @create 2020/3/29,12:50
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderApplication90 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication90.class);
    }
}
