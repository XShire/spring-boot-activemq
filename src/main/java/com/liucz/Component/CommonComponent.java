package com.liucz.Component;

import com.liucz.base.TemplateItem;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class CommonComponent {

    /**
     * 返回微信模板消息的内容
     * @param value
     * @return
     */
    public JSONObject getTempItem(String value){
        return JSONObject.fromObject(new TemplateItem(value));
    }
}
