package com.atguigu.ssm.service.impl;

import com.atguigu.ssm.entity.Emp;
import com.atguigu.ssm.mapper.EmpMapper;
import com.atguigu.ssm.service.api.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmpMapper empMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Emp> getList() {
        List<Emp> empList = empMapper.selectAll();
        return empList;
    }

    @Override
    public PageInfo<Emp> getPageInfo(Integer pageNo) {
        int pageSize = 5;
        PageHelper.startPage(pageNo,pageSize);
        List<Emp> empList = empMapper.selectAll();
        logger.debug(empList.getClass().getName());
        return new PageInfo<>(empList);
    }
}
