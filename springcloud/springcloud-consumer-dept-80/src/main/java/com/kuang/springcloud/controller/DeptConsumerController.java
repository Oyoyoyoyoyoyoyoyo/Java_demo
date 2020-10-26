package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Author:zhanggang
 * Date:2020/10/25
 * Decription:<描述>
 * @author oyoyoyoyoyoyo
 */
@RestController
public class DeptConsumerController {

    /**
     * 消费者不应该有service
     * RestTemplate 提供多种便捷访问rest方式接口的方法模板
     */
    @Autowired
    private RestTemplate restTemplate;

    // private static final String REST_URL_PREFIX = "http://localhost:8001";
    //若采用ribbon的话，地址应是变量，通过服务名来访问
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";
    @PostMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }
    @GetMapping("/consumer/dept/get/{id}")
    public String get(@PathVariable("id") Long id){
        System.out.println("------------------"+id);
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, String.class);
    }
    @GetMapping("/consumer/dept/list")
    public String list(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", String.class);
    }
}
