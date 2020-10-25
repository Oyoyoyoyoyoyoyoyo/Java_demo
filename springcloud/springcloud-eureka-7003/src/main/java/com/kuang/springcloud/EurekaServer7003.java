package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Author:zhanggang
 * Date:2020/10/25
 * Decription:<描述>
 * @author oyoyoyoyoyoyo
 */
@SpringBootApplication
@EnableEurekaServer //开启eureka-server服务,访问localhost:7001
public class EurekaServer7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003.class, args);
    }
}
