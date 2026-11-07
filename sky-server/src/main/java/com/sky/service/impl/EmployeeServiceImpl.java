package com.sky.service.impl;

import com.sky.constant.MessageConstant;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Employee;
import com.sky.exception.PasswordErrorException;
import com.sky.mapper.EmployeeMapper;
import com.sky.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.exception.AccountNotFoundException;
import org.springframework.util.DigestUtils;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public Employee login(EmployeeLoginDTO employeeLoginDTO) {
        String username=employeeLoginDTO.getUsername();
        String password=employeeLoginDTO.getPassword();
        //1、根据用户名查询数据库
        Employee employee = employeeMapper.getByUsername(username);

        if(employee==null){

            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        password= DigestUtils.md5DigestAsHex(password.getBytes());//

        if(!password.equals(employee.getPassword())){

            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);

        }

        return employee;
    }
}
