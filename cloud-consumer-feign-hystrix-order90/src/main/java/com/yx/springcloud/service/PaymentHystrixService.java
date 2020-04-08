package com.yx.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yx start
 * @create 2020/4/8,15:50
 */
@Component
// 全局的定义降级
// @FeignClient(name = "cloud-provider-hystrix-payment")
// CustomerPaymentHystrixService 总的服务降级
@FeignClient(name = "cloud-provider-hystrix-payment",fallback = CustomerPaymentHystrixService.class)
public interface PaymentHystrixService {

    @RequestMapping("/paymentInfo_ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @RequestMapping("/paymentInfo_timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);

}
