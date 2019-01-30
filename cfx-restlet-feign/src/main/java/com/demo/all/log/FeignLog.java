package com.demo.all.log;

import com.demo.all.frign.HelloClient;
import feign.Feign;
import feign.Logger;

/**
 * FeignLog
 * FeignLog的日志
 *
 * @author 10905 2019/1/30
 * @version 1.0
 */
public class FeignLog {
    public static void main(String[] args) {
        HelloClient target = Feign.builder().logLevel(Logger.Level.FULL).logger(new Logger.JavaLogger().appendToFile("D:\\Aworkspace\\logs\\springcloud\\http.log")).target(HelloClient.class, "http://localhost:8080/");
        System.out.println(target.sayHello());
    }

}
