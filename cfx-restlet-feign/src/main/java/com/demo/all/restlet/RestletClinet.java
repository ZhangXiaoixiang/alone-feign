package com.demo.all.restlet;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * RestletClinet
 *
 * @author 10905 2019/1/30
 * @version 1.0
 */
public class RestletClinet {
    public static void main(String[] args) throws IOException {

        ClientResource clientResource=new ClientResource("http://localhost:8080/person/100");
        System.out.println("注意服务最好返回json,标准的解析");
//        调用get方法,服务发布的是get
        Representation response = clientResource.get(MediaType.APPLICATION_JSON);
        System.out.println(response);
//        创建对象
        JacksonRepresentation<HashMap> jr = new JacksonRepresentation<>(response, HashMap.class);
//        获取转换后的map
        Map result =(HashMap) jr.getObject();
//        输出结果
        System.out.println(jr);
        System.out.println(result);
        System.out.println(result.get("name"));

    }

}
