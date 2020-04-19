package com.yx.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yx.springcloud.controller.blockHandler.CustomBlockHandler;
import com.yx.springcloud.payment.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示熔断降级
 * @author yx start
 * @create 2020/4/18,22:47
 */
@Slf4j
@RestController
public class RateLimitController {

    @RequestMapping("/resource_limit")
    // 如果自己不定义fallback ，调用系统的默认的
    @SentinelResource(value = "resource_limit" ,fallback = "resourceLimitError")
    public CommonResult resourceLimit(){
        return  new CommonResult(200,"success  resource 成功访问");
    }
    public CommonResult resourceLimitError(){
        return  new CommonResult(400,"error 服务不可以用");
    }


    @RequestMapping("/byUrl")
    // 如果自己不定义fallback ，调用系统的默认的
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return  new CommonResult(200,"success URL 成功访问");
    }

    /**
     * 可以自己定义异常类，自定义类，进行自定义方法
     * @return
     */
    @RequestMapping("/customHandler")
    // 如果自己不定义fallback ，调用系统的默认的
    @SentinelResource(value = "customHandler",blockHandlerClass = CustomBlockHandler.class,blockHandler = "customHandlerError")
    public CommonResult customHandler(){
        return  new CommonResult(200,"success  customHandler 成功访问");
    }

}
