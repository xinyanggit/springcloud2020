package com.yx.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author yx start
 * @create 2020/4/8,15:50
 */
@Component
public class CustomerPaymentHystrixService  implements  PaymentHystrixService{


    @Override
    public String paymentInfo_OK(Integer id) {
        return "这是代理类全局降级方法paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "这是代理类全局降级方法paymentInfo_TimeOut";
    }
}
