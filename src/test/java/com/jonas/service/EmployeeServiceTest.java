package com.jonas.service;

import com.jonas.domain.Employee;
import com.jonas.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Desc：
 * Author Jonas
 * 2018/10/31 10:37
 */
public class EmployeeServiceTest {

    private ApplicationContext ctx = null;

    private EmployeeService employeeService = null;

    @Before
    public void serup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeService = ctx.getBean(EmployeeService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void update() {
        employeeService.update(4, 20);
    }

    @Test
    public void save() {

        List<Employee> employees = new ArrayList<>();

        Employee employee = null;
        for (int i = 0; i < 100; i++) {
            employee = new Employee();
            employee.setName("test" + i);
            employee.setAge(100 - i);
            employees.add(employee);
        }

        employeeService.save(employees);
    }
}