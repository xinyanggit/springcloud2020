package com.yx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author yx start
 * @create 2020/4/9,9:41
 */
@SpringBootApplication
// 表示配置服务端
@EnableConfigServer
public class ConfigCenterMain3000 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3000.class);
    }
}
