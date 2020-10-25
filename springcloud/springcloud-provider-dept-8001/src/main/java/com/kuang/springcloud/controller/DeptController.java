package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
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
     * 添加部门（Post请求）
     * @param dept
     * @return
     */
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @GetMapping("/dept/get/{id}")
    public String get(@PathVariable("id") Long id) {
        return deptService.queryById(id).toString();
    }

    /**
     * 获取所有部门
     * @return
     */
    @GetMapping("/dept/list")
    public String queryAll() {
        System.out.println("deptService.queryAll()22222222222"+deptService.queryAll().getClass().toString());
         return Arrays.toString(deptService.queryAll().toArray());
    }
}
