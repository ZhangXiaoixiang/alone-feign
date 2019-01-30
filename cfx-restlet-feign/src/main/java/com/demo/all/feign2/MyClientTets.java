package com.demo.all.feign2;

import com.demo.all.frign.HelloClient;
import feign.Feign;
import feign.gson.GsonEncoder;

/**
 * MyClientTets
 *
 * @author 10905 2019/1/30
 * @version 1.0
 */
public class MyClientTets {
    public static void main(String[] args) {
//        获取服务接口
        HelloClient target = Feign.builder().encoder(new GsonEncoder()).client(new MyFeignClient()).target(HelloClient.class, "http://localhost:8080/");
        //请求相应接口
        String s = target.sayHello();
        System.out.println("-------------有bug----------------------");
        System.out.println("响应的内容是:   "+s);
    }
}
