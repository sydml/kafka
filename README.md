# docker：kafka单机及集群搭建及测试
**测试环境 macbook pro m1**
## 一、kafka单机版本
- 文件位置/src/main/resource/docker/docker-compose.yaml,使用是将ip换成本机的ip
#### 1. 启动 `docker-compose up -d`
   ![img_8.png](img_8.png)
#### 2. 开启管理控制台 http://localhost:9000/
- 新增kafka
  ![img.png](img.png)
  ![img_1.png](img_1.png)
#### 3. 进入容器创建topic并测试
- 创建一个消费topic

`kafka-topics.sh --create --topic test-topic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 4`
![img_6.png](img_6.png)
- 查看已创建的消费topic

`kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic test-topic`
![img_4.png](img_4.png)

- 打开生产者生产消息

`kafka-console-producer.sh --topic=test-topic --broker-list kafka:9092`
![img_5.png](img_5.png)
- 新开一个窗口打开消费者消费监听消息

`kafka-console-consumer.sh --bootstrap-server kafka:9092 --from-beginning --topic test-topic`
![img_2.png](img_2.png)

![img_7.png](img_7.png)

**参考**：
- https://www.lixueduan.com/post/kafka/01-install/
- https://juejin.cn/post/7023586768368697375
## 二、集群搭建
### 2.1 文件位置/src/main/resource/docker/docker-compose.yaml,使用是将ip换成本机的ip
#### 2.1.1 启动命令同上
![img_9.png](img_9.png)
![img_10.png](img_10.png)
### 2.2 修改代码
com.sydml.kafka.config.KafkaConsumerConfig
com.sydml.kafka.config.KafkaProducerConfig
![img_11.png](img_11.png)
### 2.2.1 启动后验证
![img_12.png](img_12.png)
![img_13.png](img_13.png)
![img_14.png](img_14.png)
