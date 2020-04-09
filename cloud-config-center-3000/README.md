当微服务越来越多，配置文件多，存在很多共性的配置，可以通过统一配置中心进行配置
#springcloud config 配置服务中心
https://cloud.spring.io/spring-cloud-static/spring-cloud-config/2.2.2.RELEASE/reference/html/
#rabbit 安装成功之后  
访问地址 http://127.0.0.1:15672/

访问配置中心访问：
http://localhost:3000/master/application-dev.yml  成功读取配置内容

配置方式：
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties


两种方式：
 1、对clientA 进行刷新。通知其他端进行刷新。违反单一职责
 2、对center进行通知刷新，统一通知各个服务。各司其职
配置yml rabbitmq + 暴漏断点
最后执行，动态刷新
一次修改，广播通知，处处生效
curl -X POST  "http://localhost:3000/actuator/bus-refresh"
这是更新全部。如果这是针对单个的呢？
destination ==> application.name:port
curl -X POST  "http://localhost:3000/actuator/bus-refresh/{destination}".
比如： 仅仅更新config-client3355 配置
curl -X POST  "http://localhost:3000/actuator/bus-refresh/config-client3355:3355"

bus官网
[https://cloud.spring.io/spring-cloud-static/spring-cloud-bus/2.2.1.RELEASE/reference/html/appendix.html][官网]
