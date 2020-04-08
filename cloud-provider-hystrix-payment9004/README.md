# hystrix服务降级熔断限流客户端
搭建新的服务之后，采用jmeter进行压测。当线程全部被占满时，出现其它应用也访问不了。这时候需要熔断降级处理
主启动类 @EnableCircuitBreaker +
service承载方法：  
@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
                         @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="4000")})
                         当超时处理时，直接调用fall_back方法

我们配置超时程序就会走fall_back
