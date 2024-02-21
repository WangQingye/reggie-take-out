package com.wqy.reggie.service.impl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wqy.reggie.entity.Employee;
import com.wqy.reggie.mapper.EmployeeMapper;
import com.wqy.reggie.service.impl.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
