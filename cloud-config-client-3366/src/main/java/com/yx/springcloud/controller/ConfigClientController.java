package com.yx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yx start
 * @create 2020/4/9,10:31
 */
@RestController
//实现刷新功能 .配合请求
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${config.version}")
    private String version  ;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo +"==>"+version;
    }

}