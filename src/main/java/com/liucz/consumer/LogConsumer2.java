package com.liucz.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class LogConsumer2 {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "log.topic", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic1(String text) {
        logger.info("发送日志Topic1:"+text);
    }

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "log.topic", containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic2(String text) {
        logger.info("发送日志Topic2:"+text);
    }

}