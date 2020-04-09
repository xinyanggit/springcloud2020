package com.yx.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author yx start
 * @create 2020/4/9,14:35
 */
@Component
@EnableBinding(Sink.class) // 这是消费端
public class StreamConsumerController {

    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者8003"+message.getPayload()+"==>port:"+serverPort );
    }

}
