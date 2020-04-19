package com.yx.springcloud.controller;

import com.yx.springcloud.payment.entity.CommonResult;
import com.yx.springcloud.payment.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author yx start
 * @create 2020/4/19,9:40
 */
@RestController
public class PaymentController {

    // 2的2次方 = 4
    // 2的6 ==》64
    // 2的8  => 4 * 4 * 4 * 4 = >256


    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Integer, Payment> resMap = new HashMap<>();

    static {
        resMap.put(1, new Payment(1, "你是老大"));
        resMap.put(2, new Payment(2, "老二"));
        resMap.put(3, new Payment(3, "老三"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Integer id) {
        Payment payment = resMap.get(id);
        CommonResult<Payment> result = new CommonResult(200, "from mysql,serverPort:  " + serverPort, payment);
        return result;
    }


}