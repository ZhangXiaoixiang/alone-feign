package com.demo.all.cxf;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

/**
 * CxfClient
 *
 * @author 10905 2019/1/30
 * @version 1.0
 */
public class CxfClient {
    public static void main(String[] args) throws IOException {
//        创建客户端
        WebClient client=WebClient.create("http://localhost:8080/findPerson/2019");
//        获取响应
        Response response = client.get();
//        获取响应内容
        InputStream entity = (InputStream)response.getEntity();
        String s = IOUtils.readStringFromStream(entity);
        System.out.println("---------------------------请求的地址返回的内容如下:---------------------------------\n");
        System.out.println(s);
    }
}
