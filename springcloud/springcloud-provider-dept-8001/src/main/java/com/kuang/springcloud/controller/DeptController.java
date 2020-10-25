package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;

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
    /**
     * 获取eureka配置信息
     */
    @Autowired
    private DiscoveryClient client;

    /**
     * 添加部门（Post请求）
     *
     * @param dept
     * @return
     */
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    /**
     * 根据id查询部门
     *
     * @param id
     * @return
     */
    @GetMapping("/dept/get/{id}")
    public String get(@PathVariable("id") Long id) {
        return deptService.queryById(id).toString();
    }

    /**
     * 获取所有部门
     *
     * @return
     */
    @GetMapping("/dept/list")
    public String queryAll() {
        System.out.println("deptService.queryAll()22222222222" + deptService.queryAll().getClass().toString());
        return Arrays.toString(deptService.queryAll().toArray());
    }

    /**
     * 注册进来的微服务，获取关键信息
     */
    @GetMapping("/dept/discovery")
    public Object discovery() {
        //    获取微服务列表清单
        List<String> services = client.getServices();
        System.out.println("services-------------:" + services);
        //    获取具体微服务信息
        final List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                            instance.getPort() + "\t" +
                            instance.getUri() + "\t" +
                            instance.getServiceId() + "\t"
            );
        }
        return this.client;
    }
}
