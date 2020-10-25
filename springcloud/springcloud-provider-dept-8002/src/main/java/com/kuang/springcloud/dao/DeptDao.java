package com.kuang.springcloud.dao;

import com.kuang.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:zhanggang
 * Date:2020/10/22
 * Decription:<描述>
 * @author oyoyoyoyoyoyo
 */
@Mapper
@Repository
public interface DeptDao {
    public boolean addDept(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();

}
