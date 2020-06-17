package com.yx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yx start
 * @create 2020/4/19,9:55
 */
@SpringCloudApplication
@EnableFeignClients
public class CustomMain50 {
    public static void main(String[] args) {
        SpringApplication.run(CustomMain50.class,args);
    }
}
