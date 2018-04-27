package com.liucz.consumer;

import com.liucz.base.Template;
import net.sf.json.JSONObject;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class Consumer1{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "message.queue", containerFactory = "jmsListenerContainerQueue")
    @SendTo("messageOut.queue")
    public String receiveQueue(ActiveMQObjectMessage text) throws JMSException {

        Template template = (Template) text.getObject();
        logger.info("发送消息:" + template.toString());

        JSONObject result = new JSONObject();
        result.put("errcode",0);
        result.put("errmsg","ok");
        result.put("msgid",200228332);

        //不支持发送JSON对象，所以转为String类型
        return result.toString();
    }

}