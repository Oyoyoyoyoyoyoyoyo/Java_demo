package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Author:zhanggang
 * Date:2020/10/25
 * Decription:<Feign调用服务,项目spingcloud-consumer-dept-feigin访问测试用>
 */
@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT") //调用对应的服务，就可以获取其对应的接口
public interface DeptClientService {
    @GetMapping("/dept/get/{id}")
    public String queryById(@PathVariable("id") Long id);

    @GetMapping("dept/list")
    public String queryAll();

    @PostMapping("/dept/add")
    public Boolean addDept(Dept dept);
}
