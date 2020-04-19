package com.yx.springcloud.service;

import com.yx.springcloud.payment.entity.CommonResult;
import com.yx.springcloud.payment.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yx start
 * @create 2020/4/19,10:06
 */
@FeignClient(value = "cloud-alibaba-nacos-provider",fallback = PaymentServiceImpl.class )
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Integer id);
}
