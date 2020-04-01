package com.yx.order.controller;

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
    private RestTemplate restTemplate;

    // 服务方请求与url
    //private static final String PROVIDER_URL = "http://localhost:9001/";
    // 直接调用服务名称 演示eureka
    // private static final String PROVIDER_URL = "http://cloud-provider-payment";

    // 演示 zookeeper
     private static final String PROVIDER_URL = "http://cloud-provider-zk-payment";

    @GetMapping("/payment/zk")
    public String  getPaymentById( ) {
        return restTemplate.getForObject(PROVIDER_URL + "/payment/zk" , String .class);
    }

}
