package com.yx.springcloud;

import com.yx.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author yx start
 * @create 2020/3/29,12:50
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name="cloud-provider-payment",configuration = MySelfRule.class)
@EnableHystrix  // 客户端用@EnableHystrix 。服务提供方用 @EnableCircuitBreaker
public class OrderApplication90 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication90.class);
    }
}
