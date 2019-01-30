package com.demo.all.frign;

import com.demo.all.mode.Person;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.jaxrs.JAXRSContract;

/**
 * FeignTest
 *
 * @author 10905 2019/1/30
 * @version 1.0
 */
public class FeignTest {
    public static void main(String[] args) {
        /**
         *  http://localhost:8080/表示前缀,HelloClient这是代理的类的对象,target.sayHello()调用现已代理对象的方法
         */
        HelloClient target = Feign.builder().target(HelloClient.class, "http://localhost:8080/");
//        注意返回对象
        HelloClient target2 = Feign.builder().decoder(new GsonDecoder()).target(HelloClient.class, "http://localhost:8080/");
        //注意编码
        HelloClient target3 = Feign.builder().encoder(new GsonEncoder()).target(HelloClient.class, "http://localhost:8080/");

        System.out.println(target.sayHello());
        System.out.println(target2.getPerson(777).toString());
        System.out.println(target3.getJsonPerosn(new Person(102,"我是json名字",null,15)));
        //        第三方注解的方式.contract(new JAXRSContract())解析
        RsClient target4 = Feign.builder().contract(new JAXRSContract()).target(RsClient.class, "http://localhost:8080/");
        System.out.println("注解接口不能混用");
        System.out.println(target4.reHello());


    }
}
