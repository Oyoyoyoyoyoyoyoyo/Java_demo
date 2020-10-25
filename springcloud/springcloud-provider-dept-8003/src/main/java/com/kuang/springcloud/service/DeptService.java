package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;

import java.util.List;

/**
 * Author:zhanggang
 * Date:2020/10/23
 * Decription:<描述>
 * @author oyoyoyoyoyoyo
 */
public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();
}
