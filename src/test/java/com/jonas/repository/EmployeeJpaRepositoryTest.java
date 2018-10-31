package com.jonas.repository;

import com.jonas.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Desc：
 * Author Jonas
 * 2018/10/30 17:36
 */
public class EmployeeJpaRepositoryTest {

    private ApplicationContext ctx = null;

    private EmployeeJpaRepository employeeJpaRepository = null;


    @Before
    public void serup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaRepository = ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void find(){

        Employee employee = employeeJpaRepository.findOne(99);

        System.out.println(employee.toString());
        System.out.println("employee(10)：" + employeeJpaRepository.exists(10));
        System.out.println("employee(102)：" + employeeJpaRepository.exists(102));
    }

}