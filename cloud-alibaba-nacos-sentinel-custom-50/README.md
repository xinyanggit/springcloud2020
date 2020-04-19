1.sentinel 熔断演示

消费者端 50
服务提供者 5001
服务提供者 5002

效果：通过 rabbion ，
 需要@SentinelResource(value = "fallback")

@SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
            // 忽略此异常
            exceptionsToIgnore = {IllegalArgumentException.class})
~blockHandler针对限流进行处理，不处理程序异常~

需要fallback方法。当服务down之后，可以降级。


限流规则：
 持久化进入nacos / redis /
  当应用 重启之后，规则就没有了。
 
如果修改：
 添加pom  sentinel-datasource-nacos
 具体表现在cloud-alibaba-sentinel-service8849 演示
 1.添加pom
 2.修改yml
 3.在nacos 添加
 [
     {
         "resource": "/byUrl",
         "limitApp": "default",
         "grade": 1,
         "count": 5,
         "strategy": 0,
         "controlBehavior": 0,
         "clusterMode": false
     }
 ]
 resource:资源名称
 limitApp：来源应用
 grade：阈值类型：0表示线程数 1表示QPS
 count：单机阈值
 strategy：流控模式 0 表示直接  1 表示关联 2 表示链路
 controlBehavior: 流控效果 0 表示快速失败 1表示预热 2 表示排队等待
 clusterMode 是否集群
 
 
 
 
 
 
 
 
 
 
 
 
 





