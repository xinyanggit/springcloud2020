package com.yx.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yx.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yx start
 * @create 2020/4/8,15:49
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }

    /** 狠的。利用全局
     * 超时访问
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout_all/{id}")
   /* @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    @HystrixCommand // 添加了这个，但是没有具体指明，就用默认的。在class 上面添加 @DefaultProperties
    public String paymentInfo_TimeOut_default(@PathVariable("id") Integer id) {
        int age = 10 / 0; //方法前挂了，跟后面挂了两种
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }


    /**
     * 自己定义，针对该业务处理
     * @param id
     * @return
     */
    // 一定要在启动类添加， 配置文件添加，
    @GetMapping("/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            // 超过1.5s直接走服务降级
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
     public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
     //   int age = 10 / 0; //方法前挂了，跟后面挂了两种
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    /**
     * 如果指定，就会
     * @param id
     * @return
     */
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80,对方支付系统繁忙请10秒种后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    //下面是全局fallback方法
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后再试,/(ㄒoㄒ)/~~";
    }
    // 上面处理的是 服务超时 和程序异常。 还有一个服务 停机
    /**服务停机的操作：
     *  1.实现该接口 CustomerPaymentHystrixService.java
     *  2.添加 @FeignClient(name = "cloud-provider-hystrix-payment",fallback = CustomerPaymentHystrixService.class)
     *  3.这是防止服务提供者宕机，返回一个预期返回值
    ***/

}
