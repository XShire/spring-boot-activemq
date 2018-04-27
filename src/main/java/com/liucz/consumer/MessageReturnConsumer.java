package com.liucz.consumer;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReturnConsumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "messageOut.queue", containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue(String objText) {
        logger.info("发送消息返回值:"+objText);
        JSONObject result = JSONObject.fromObject(objText);
        logger.info("返回消息："+result.getString("errmsg"));
    }

}
