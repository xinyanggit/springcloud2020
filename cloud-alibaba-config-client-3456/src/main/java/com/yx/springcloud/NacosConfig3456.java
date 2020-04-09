package com.yx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yx start
 * @create 2020/4/9,16:41
 */
@SpringBootApplication
@EnableDiscoveryClient // nacos 服务注册
public class NacosConfig3456 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfig3456.class, args);
    }
}