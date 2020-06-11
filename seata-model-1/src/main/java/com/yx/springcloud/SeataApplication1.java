package com.yx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yx start
 * @create 2020/6/11,17:19
 */
@EnableDiscoveryClient
@EnableFeignClients({"com.yx.springcloud"})
@SpringBootApplication
public class SeataApplication1 {
    public static void main(String[] args) {
        SpringApplication.run(SeataApplication1.class, args);
    }
}
