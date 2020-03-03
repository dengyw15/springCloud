package com.dyw.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {

    private Long deptno;
    private String dname;
    private String db_souce; //来自哪个数据库，由于微服务框架可以一个服务对应一个数据库，同一个信息被存储到不同数据库
}
