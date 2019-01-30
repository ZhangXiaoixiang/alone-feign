package com.demo.all.interceptor;

import com.demo.all.frign.HelloClient;
import feign.Feign;

public class InterceptorTest {

	public static void main(String[] args) {
		// 获取服务接口
		HelloClient target = Feign.builder()
				.requestInterceptor(new MyInterceptor())
				.target(HelloClient.class, "http://localhost:8080/");
		System.out.println(target.sayHello());
	}
}
