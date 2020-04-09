package com.yx.springcloud.controller;

import com.yx.springcloud.service.IMassageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yx start
 * @create 2020/4/9,13:52
 */
@RestController
public class SendMessageController {
    @Resource
    private IMassageProvider massageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return massageProvider.send();
    }
}
