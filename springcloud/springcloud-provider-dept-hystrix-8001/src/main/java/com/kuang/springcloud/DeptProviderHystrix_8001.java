package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author:zhanggang
 * Date:2020/10/23
 * Decription:<服务启动类>
 *
 * @author oyoyoyoyoyoyo
 */
@SpringBootApplication
@EnableEurekaClient //开启eureka-clicent服务，自动注册到eureka中
@EnableDiscoveryClient //服务发现，获取eureka相关配置信息用
@EnableCircuitBreaker //添加对熔断的支持hystrix
public class DeptProviderHystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix_8001.class, args);
    }
}
