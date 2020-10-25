package com.kuang.springcloud.service;

import com.kuang.springcloud.dao.DeptDao;
import com.kuang.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:zhanggang
 * Date:2020/10/23
 * Decription:<描述>
 */
@Service
public class DeptServiceImpl implements DeptService {
    //service的实现类写入dao的方法

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(Long id) {
        return deptDao.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        System.out.println("deptDao1111111---------"+deptDao.queryAll().get(1).toString());
        System.out.println("deptDao.queryAll()---------"+deptDao.queryAll());
        return deptDao.queryAll();
    }
}
