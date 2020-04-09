NACOS raft协议 =>可以动态调整
ZK CP 
Consul CP 

Eureka AP 
Nacos CP+AP
如何进行调整呢？
默认AP
执行指令：
curl -X PUT
'$NACOS_SERVER:8848/nacos/v1/ns/operator/switches?entry=serverMode&value=CP'

NACOS 支持CP +AP 的切换
