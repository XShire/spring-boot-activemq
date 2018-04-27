package com.liucz.base;

import java.io.Serializable;
import java.util.Map;

public class Template implements Serializable {

    private static final long serialVersionUID = -4518760021665800612L;
    private String touser;
    private String template_id;
    private String url;
    private Map data;

    public Template(String touser, String template_id, String url, Map data) {
        this.touser = touser;
        this.template_id = template_id;
        this.url = url;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Template{" +
                "touser='" + touser + '\'' +
                ", template_id='" + template_id + '\'' +
                ", url='" + url + '\'' +
                ", data=" + data +
                '}';
    }
}
