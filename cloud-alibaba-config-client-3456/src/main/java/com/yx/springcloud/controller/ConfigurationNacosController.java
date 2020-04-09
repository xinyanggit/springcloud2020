package com.yx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yx start
 * @create 2020/4/9,17:39
 */
@RestController
//实现刷新功能。暴漏端点一起使用
@RefreshScope
public class ConfigurationNacosController {


    @Value("${config.info}")
    private String configInfo;

    @Value("${config.version}")
    private String version  ;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo +"==>"+version;
    }

}
