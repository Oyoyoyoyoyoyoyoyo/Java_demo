package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Author:zhanggang
 * Date:2020/10/25
 * Decription:<使用Feign实现Rest请求>
 *
 * @author oyoyoyoyoyoyo
 */
@RestController
public class DeptConsumerController {


    @Autowired
    private DeptClientService deptClientService = null;

    @PostMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return this.deptClientService.addDept(dept);
    }

    @GetMapping("/consumer/dept/get/{id}")
    public String get(@PathVariable("id") Long id) {
        return this.deptClientService.queryById(id);
    }

    @GetMapping("/consumer/dept/list")
    public String list() {
        return this.deptClientService.queryAll();
    }
}
