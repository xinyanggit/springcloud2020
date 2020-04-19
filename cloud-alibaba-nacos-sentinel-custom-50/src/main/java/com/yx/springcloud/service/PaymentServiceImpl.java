package com.yx.springcloud.service;

import com.yx.springcloud.payment.entity.CommonResult;
import com.yx.springcloud.payment.entity.Payment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author yx start
 * @create 2020/4/19,10:07
 */
@Component
public class PaymentServiceImpl implements  PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Integer id) {
        return new CommonResult<>(400,"Error 錯誤頁面");
    }
}
