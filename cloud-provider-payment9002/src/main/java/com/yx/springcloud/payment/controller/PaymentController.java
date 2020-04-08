package com.yx.springcloud.payment.controller;

import com.yx.springcloud.payment.entity.CommonResult;
import com.yx.springcloud.payment.entity.Payment;
import com.yx.springcloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    private PaymentService paymentService ;

    @PostMapping("/create")
    public CommonResult creatPayment(@RequestBody  Payment payment){
        Payment resPayment = paymentService.insert(payment);
        log.info("******插入结果"+resPayment);
        if ( resPayment!=null ){
            return new CommonResult(200,"插入数据库成功,serverPort:"+serverPort,resPayment);
        }else{
            return new CommonResult(444,"插入数据库失败,serverPort:"+serverPort);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")  Integer  id){
        Payment payment = paymentService.queryById(id);
        log.info("***{},***查询结果{}",serverPort,payment);
        return new CommonResult(200,"查询成功,serverPort"+serverPort,payment);
    }

    /***** 测试openFeign超时策略 **/

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





}
