package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Author:zhanggang
 * Date:2020/10/23
 * <p>
 * dao->定义方法->mapper.xml实现方法内容->serviceImpl实现dao的方法，并传给controller-->restAPI调用接口
 * <p>
 * Decription:<描述>
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")//表示失败的时候调用发方法为hystrixGet
    public String get(@PathVariable("id") Long id) {
        System.out.println("800000000000001----" + id);
        return deptService.queryById(id).toString();
    }

    /**
     * 备选方法
     *
     * @param id
     * @return
     */
    public String hystrixGet(@PathVariable("id") Long id) {

        return "id:" + id + "不存在该用户（hystrix触发）";
    }
}
