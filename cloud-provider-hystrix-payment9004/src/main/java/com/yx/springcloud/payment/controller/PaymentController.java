package com.yx.springcloud.payment.controller;

import com.yx.springcloud.payment.entity.CommonResult;
import com.yx.springcloud.payment.entity.Payment;
import com.yx.springcloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yx start
 * @create 2020/3/28,15:36
 */
@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @RequestMapping("/paymentInfo_ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentService.paymentInfo_OK(id) + "==>端口：" + serverPort;
    }

    @RequestMapping("/paymentInfo_timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return paymentService.paymentInfo_TimeOut(id) + "==>端口：" + serverPort;
    }


    /*************************************服务熔断*****************************************/
    // 断路器   open  close  salf-open
    @RequestMapping("/payment/cricuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String s = paymentService.paymentCircuitBreaker(id);
        log.info("*****{}", s);
        return s;
    }

}
