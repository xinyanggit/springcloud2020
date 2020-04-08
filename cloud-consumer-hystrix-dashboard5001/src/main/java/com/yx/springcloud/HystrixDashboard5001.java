package com.yx.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @author yx start
 * @create 2020/4/8,17:16
 */
@SpringBootApplication
@EnableHystrixDashboard // 启动hystrix 面板监控
public class HystrixDashboard5001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard5001.class,args);
    }

}
