1. cloud Stream 消费者

消费者
@EnableBinding(Sink.class) // 这是消费端
  @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者8002"+message.getPayload()+"==>port:"+serverPort );
    }