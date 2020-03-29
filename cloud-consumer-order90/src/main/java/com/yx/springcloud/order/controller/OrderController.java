package com.yx.springcloud.order.controller;

import com.yx.springcloud.payment.entity.CommonResult;
import com.yx.springcloud.payment.entity.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author yx start
 * @create 2020/3/29,12:49
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    // 服务方请求与url
    //private static final String PROVIDER_URL = "http://localhost:9001/";
    // 直接调用服务名称
    private static final String PROVIDER_URL = "http://cloud-provider-payment";

    @GetMapping("/payment/create")
    public CommonResult<Payment> creatPayment(Payment payment) {
        return restTemplate.postForObject(PROVIDER_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PROVIDER_URL + "/payment/get/" + id, CommonResult.class);
    }

}
