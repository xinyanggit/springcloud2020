spring Cloud Stream 核心操作

middleware:中间件，目前只支持RabbitMQ 和 Kafaka
Binder:binder是应用与消息中间件之间的封装，目前实行了kafaka与rabbitmq的Binder
@input : 注解标识输入通道，通过该输入通道接收的消息进入应用程序。消费者
@output： 注解标识输出通道，发布消息将通过改通道离开应用程序
@StreamListener： 监听队列，用于消费者的队列的消息接收
@EnabelBinding : 信道channel和exchange绑定在一起


生产者
@EnableBinding(Source.class) // 指信道channel和exchange绑定在一起 。定义消息的推送管道
   @Resource
    private IMassageProvider massageProvider;
     @Override
        public String send() {
            String serial = UUID.randomUUID().toString();
            output.send(MessageBuilder.withPayload(serial).build());
            System.out.println("*****serial:" + serial);
            return null;
        }
 
 
--> 分组消费与持久化 
环境如下：
eureka 注册集群
发送者 8801
消费者8002
消费者8003
pub/sub 就会出现同时受到

---> 存在问题，重复消费问题
分组和持久化能解决该问题

结论： 不同的组是可以重复消费的。
       同一组内发生竞争关系，只有其中一个可以消费
默认是不同组的。
1.自定义分组
2.如何分成相同的组
添加 
分组属性： group: yx_group1 #自定义分组名称 名称会变为：studyExchange.yx_group1
添加group之后，会持久化数据，当服务端发送，客户端未收到，也可以重启能收到信息
