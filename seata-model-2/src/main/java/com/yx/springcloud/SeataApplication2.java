package com.yx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yx start
 * @create 2020/6/11,17:19
 */
@EnableFeignClients({"com.yx"})
@EnableDiscoveryClient
@SpringBootApplication
public class SeataApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(SeataApplication2.class, args);
    }
}
