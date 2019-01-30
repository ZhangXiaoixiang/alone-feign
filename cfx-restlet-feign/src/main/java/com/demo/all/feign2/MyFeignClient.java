package com.demo.all.feign2;

import feign.Client;
import feign.Request;
import feign.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;

/**
 * MyFeignClient
 *
 * @author 10905 2019/1/30
 * @version 1.0
 */
public class MyFeignClient implements Client {
    //    @Override
//    public Response execute(Request request, Request.Options options) throws IOException {
//        System.out.println("------------------这是自定义的Feign客户端--------");
//        Response response=null;
//        try {
////        创建默认客户端
//            CloseableHttpClient httpClient = HttpClients.createDefault();
////        获取http方法
//            /**
//             * 弃用
//             */
//            String method = request.method();
//            Request.HttpMethod httpMethod = request.httpMethod();
////创建一个httpclient的httprequest
//            HttpRequestBase httpRequestBase = new HttpRequestBase() {
//                @Override
//                public String getMethod() {
//                    return method;
//                }
//            };
////        设置请求地址
//
//            httpRequestBase.setURI(new URI(request.url()));
////            执行响应
//            HttpResponse httpResponse = httpClient.execute(httpRequestBase);
//            byte[] body = EntityUtils.toByteArray(httpResponse.getEntity());
////            对象转换
//             response = Response.builder()
//                    .body(body)
//                    .headers(new HashMap<String, Collection<String>>())
//                    .status(httpResponse.getStatusLine().getStatusCode())
//                    .build();
//            return response;
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    @Override
    public Response execute(Request request, Request.Options options)
            throws IOException {
        System.out.println("-----------这是自定义的Feign客户端-------------");
        try {
            // 创建一个默认的客户端
            CloseableHttpClient httpclient = HttpClients.createDefault();
            // 获取调用的HTTP方法
            final String method = request.method();
            // 创建一个HttpClient的HttpRequest

            HttpRequestBase httpRequest = new HttpRequestBase() {
                @Override
                public String getMethod() {
                    return method;
                }
            };
            // 设置请求地址
            httpRequest.setURI(new URI(request.url()));
            // 执行请求，获取响应
            HttpResponse httpResponse = httpclient.execute(httpRequest);
            // 获取响应的主体内容
            byte[] body = EntityUtils.toByteArray(httpResponse.getEntity());
            // 将HttpClient的响应对象转换为Feign的Response
            Response response = Response.builder()
                    .body(body)
                    .headers(new HashMap<String, Collection<String>>())
                    .status(httpResponse.getStatusLine().getStatusCode())
                    .build();
            return response;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
