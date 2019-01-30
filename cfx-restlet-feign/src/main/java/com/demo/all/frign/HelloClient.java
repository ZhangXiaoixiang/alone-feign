package com.demo.all.frign;

import com.demo.all.mode.Person;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * HelloClient
 * 注解修饰接口sayHello
 */
public interface HelloClient {
    /**
     * feign自带注解
     * hello表示将要被代理对象的请求
     * @return
     */
    @RequestLine("GET /hello")
    String sayHello();




    @RequestLine(("GET /person/{id}"))
    Person getPerson(@Param("id") Integer id);
    /**
     * 入参是对象
     */
    @RequestLine("GET /jsonPerson")
    @Headers("Content-Type: application/json")
    String getJsonPerosn(Person person);

}
