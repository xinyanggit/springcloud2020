package com.yx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yx start
 * @create 2020/3/29,15:36
 */
@SpringBootApplication
// eureka 服务端启动
@EnableEurekaServer
public class EurekaServer6001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer6001.class);
    }
}
