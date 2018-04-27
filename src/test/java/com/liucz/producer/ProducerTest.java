package com.liucz.producer;

import com.liucz.Component.CommonComponent;
import com.liucz.base.Template;
import com.liucz.base.TemplateItem;
import net.sf.json.JSONObject;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;
import javax.jms.ObjectMessage;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Producer producer;
    @Autowired
    CommonComponent commonComponent;

    @Test
    public void sendMessage() {

        Destination message = new ActiveMQQueue("message.queue");
        Destination log = new ActiveMQQueue("log.queue");

        String touser = "OPENID";
        String template_id = "ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY";
        String url = "http://weixin.qq.com/download";
        Map data = new HashMap();
        data.put("first",commonComponent.getTempItem("恭喜你购买成功！"));
        data.put("keyword1",commonComponent.getTempItem("巧克力"));
        data.put("keyword2",commonComponent.getTempItem("39.8元"));
        data.put("keyword3",commonComponent.getTempItem("2014年9月22日"));
        data.put("remark",commonComponent.getTempItem("欢迎再次购买！"));
        Template template = new Template(touser, template_id, url, data);

        //不支持发送JSON对象，所以转为String类型
        producer.sendMessage(message, template);
        producer.sendMessage(log, "生产者发送了日志");

    }

}
