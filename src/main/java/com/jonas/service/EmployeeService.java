package com.jonas.service;

import com.jonas.domain.Employee;
import com.jonas.repository.EmployeeCrudRepository;
import com.jonas.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Desc：
 * Author Jonas
 * 2018/10/31 10:31
 */
@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    public void update(Integer id, Integer age) {
        employeeRepository.update(id, age);
    }

    public void save(List<Employee> employees) {
        employeeCrudRepository.save(employees);
    }

}
