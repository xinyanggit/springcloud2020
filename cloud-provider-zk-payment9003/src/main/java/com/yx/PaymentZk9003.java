package com.yx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yx start
 * @create 2020/4/1,23:13
 */
@SpringBootApplication
@EnableDiscoveryClient  // zk 注册添加
public class PaymentZk9003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZk9003.class);
    }
}
