package com.yx.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yx start
 * @create 2020/4/11,21:26
 */
@Slf4j
@RestController
public class SentinelController {

    @RequestMapping("/service/A")
    @SentinelResource("/service/A")
    public String serviceA(){
        return "this is service A";
    }

    @RequestMapping("/service/B")
    @SentinelResource("/service/B")
    public String serviceB(){
        return "this is service B";
    }

    @RequestMapping("/service/C")
    @SentinelResource("/service/C")
    public String serviceC(){
        log.info(Thread.currentThread().getName()+"\t testC");
        return "this is service C";
    }


    /**
     *  测试线程数 直接失败的策略
     * @return
     */
    @RequestMapping("/service/timeOut")
    @SentinelResource("/service/timeOut")
    public String serviceTimeOut(){
        try {
            Thread.sleep(800);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "this is service C";
    }

    /** 访问方法：http://localhost:8849/service/param?name1=1
     * 设置1s1次
     *blockHandler 兜底方法
     *
     * @param name1
     * @param name2
     * @return
     */
    @RequestMapping("/service/param")
    @SentinelResource(value = "/service/param",blockHandler = "error_block")
    public String serviceParam(@RequestParam(value = "name1",required = false) String name1 ,
                               @RequestParam(value = "name2",required = false) String name2 ){
        return "this is serviceParam  param,test Param "+name1 +"==>name2="+name2;
    }


    /**
     * 兜底方法注意需要添加BlockException
     * @param name1
     * @param name2
     * @param exception
     * @return
     */
    public String error_block(String name1 ,
                              String name2 , BlockException exception){
        return "this is error_block serviceParam ";
    }

}
