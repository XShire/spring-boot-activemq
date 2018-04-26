package com.liucz.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.ObjectMessage;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Service
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    // 发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(Destination destination, final Object message) {
        jmsTemplate.convertAndSend(destination, message);
    }


//    public void send(Destination destination, final Serializable order) {
//
//        //order对象是普通pojo对象 需要实现序列化接口
//        jmsTemplate.convertAndSend(destination,order);
//
//    }

}
