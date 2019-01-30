package com.demo.all.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class MyInterceptor implements RequestInterceptor {
@Override
	public void apply(RequestTemplate template) {
		template.header("Content-Type", "application/json");
	}
}
