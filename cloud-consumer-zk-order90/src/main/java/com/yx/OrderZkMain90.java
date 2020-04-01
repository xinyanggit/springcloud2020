package com.yx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yx start
 * @create 2020/4/1,23:26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain90 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain90.class, args);
    }
}
