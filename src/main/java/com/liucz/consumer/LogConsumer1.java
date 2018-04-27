package com.liucz.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class LogConsumer1 {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "log.queue", containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue1(String text) {
        logger.info("发送日志Queue1:"+text);
    }

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "log.queue", containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue2(String text) {
        logger.info("发送日志Queue2:"+text);
    }

}