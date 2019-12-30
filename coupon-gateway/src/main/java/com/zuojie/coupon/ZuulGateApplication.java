package com.zuojie.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * <h1>网关应用启动入口</h1>
 * 1. @EnableZuulProxy 标识当前的应用是 Zuul Server
 * 2. @SpringCloudApplication 组合了 SpringBoot 应用 + 服务发现 + 熔断
 * author:zuojie
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulGateApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGateApplication.class,args);

    }
}
