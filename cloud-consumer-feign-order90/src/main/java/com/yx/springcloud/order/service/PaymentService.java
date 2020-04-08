package com.yx.springcloud.order.service;

import com.yx.springcloud.payment.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * OpenFeign 对应provider
 * @author yx start
 * @create 2020/4/8,13:39
 */

@Component
//针对服务提供者做面向接口编程
@FeignClient(name="cloud-provider-payment")
public interface PaymentService {

    @GetMapping("/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Integer id);

    @GetMapping("/payment/time_ok")
    String  timeOk();

    @GetMapping("/payment/time_out")
    String  timeOut() ;

}
