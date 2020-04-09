#springcloud config 配置客户端，就是后面的微服务
bootstrap.yml 文件优先级高于应用程序文件优先级
通过api暴漏的接口，能正常访问到数据。
当修改github之前，发现服务中心更新，但是微服务这边没有更新？？
  需要手动更新。动态刷新。需要用pom acutor.jar
  动态刷新-->手动刷新
  必须是post请求
  curl -X  POST "http://localhost:3355/actuator/refresh"
  缺点：每一个微服务修改都需要手动去刷新，不方便。麻烦===>引入springcloubd bus 消息总线
  
 1.新建model
 2.改pom
 3.改yml
 4.主启动类
 
 添加spring cloud bus  
 `<!--添加消息总线Rabbitmq支持-->
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-bus-amqp</artifactId>
          </dependency>  `
   