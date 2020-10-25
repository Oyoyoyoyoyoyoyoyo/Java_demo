package com.kuang.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Author:zhanggang
 * Date:2020/10/22
 * Decription:<Dept实体类，类表关系映射>
 * Accessors链式写法注解
 *
 * @author oyoyoyoyoyoyo
 */
@Data

@Accessors(chain = true)
public class Dept implements Serializable {

    private Long deptno;
    private String dname;
    /**
     * 这个数据存在哪个数据库的字段，微服务，一个服务对应一个数据库，同一个信息可能存在不同的数据库
     */
    private String db_source;

    public Dept() {
    }

    public Dept(String dname) {
        this.dname = dname;
    }

    public Dept(Long deptno, String dname, String db_source) {
        this.deptno = deptno;
        this.dname = dname;
        this.db_source = db_source;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", db_source='" + db_source + '\'' +
                '}';
    }
}
