package com.demo.all.frign;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface RsClient {
    /**
     * 第三方注解
     * 和原生的一样,但是不能混用
     * @return
     */
    @GET
    @Path("/hello")
    String reHello();
}
