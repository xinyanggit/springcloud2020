package com.yx.springcloud.order.controller;

import com.yx.springcloud.order.service.PaymentService;
import com.yx.springcloud.payment.entity.CommonResult;
import com.yx.springcloud.payment.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    private PaymentService paymentService;


    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id) {
         return paymentService.getPaymentById(id) ;
    }

    /********测试 openFeign超时逻辑 ***/
    /***
     * 服务提供者正常调用
     * @return
     */
    @GetMapping("/payment/time_ok")
    public String  timeOk() {
        return paymentService.timeOk();
    }

    /**
     * 服务提供者进行超时等待
     * 默认1秒中
     * @return
     */
    @GetMapping("/payment/time_out")
    public String  timeOut() {
        return paymentService.timeOut();
    }

}
