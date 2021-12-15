package com.atguigu.ssm.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.ssm.entity.Emp;
import com.atguigu.ssm.mapper.EmpMapper;
import com.atguigu.ssm.service.api.EmpService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringJUnitConfig(locations = {"classpath:spring-persist.xml"})
public class SSMTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DruidDataSource dataSource;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpService empService;

    @Test
    public void testTx(){
        List<Emp> empList = empService.getList();
        for (Emp emp : empList) {
            System.out.println("emp = " + emp);
        }
    }

    @Test
    public void testConn() throws SQLException {
        Connection connection = dataSource.getConnection();
        logger.debug("connection = " + connection);
    }

    @Test
    public void testMybatis() throws SQLException {
        List<Emp> empList = empService.getList();
        for (Emp emp : empList) {
            logger.debug("emp = " + emp);
        }
    }
}
