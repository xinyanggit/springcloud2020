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
@RequestMapping("/payment")
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult creatPayment(@RequestBody Payment payment) {
        Payment resPayment = paymentService.insert(payment);
        log.info("******插入结果" + resPayment);
        if (resPayment != null) {
            return new CommonResult(200, "插入数据库成功,serverPort:" + serverPort, resPayment);
        } else {
            return new CommonResult(444, "插入数据库失败,serverPort:" + serverPort);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id) {
        Payment payment = paymentService.queryById(id);
        log.info("******查询结果" + payment);
        return new CommonResult(200, "查询成功,serverPort" + serverPort, payment);
    }

    @GetMapping("/zipkin")
    public String zipkin() {
        return   " this is  zipkin " ;
    }





    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 获得所有ecureka中所有的微服务
     *
     * @return
     */
    @RequestMapping("/discovery")
    public Object discoveryClient() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("当前服务:{}", service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        for (ServiceInstance instance : instances) {
            log.info("CLOUD-PROVIDER-PAYMENT有服务{}\t host {} port{}-->uri{}", instance.getServiceId(),instance.getHost(),
                    instance.getPort(),instance.getUri() );
        }
        /**
         CLOUD-PROVIDER-PAYMENT有服务CLOUD-PROVIDER-PAYMENT	 host 192.168.31.226 port9002-->urihttp://192.168.31.226:9002
         CLOUD-PROVIDER-PAYMENT有服务CLOUD-PROVIDER-PAYMENT	 host 192.168.31.226 port9001-->urihttp://192.168.31.226:9001
         */
        // {"services":["cloud-provider-payment","cloud-consumer-order90"],"order":0}
        return discoveryClient;
    }


    @GetMapping("/time_ok")
    public String  timeOk() {
        return serverPort + "ok";
    }


    @GetMapping("/time_out")
    public String  timeOut() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort +"time_Oout";
    }

    @GetMapping(value ="/lb")
    public String getPaymentLB(){
        return serverPort;
    }


}
