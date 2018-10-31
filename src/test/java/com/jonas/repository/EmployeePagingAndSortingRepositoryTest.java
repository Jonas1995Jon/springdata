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

import java.util.ArrayList;
import java.util.List;

/**
 * Desc：
 * Author Jonas
 * 2018/10/30 17:36
 */
public class EmployeePagingAndSortingRepositoryTest {

    private ApplicationContext ctx = null;

    private EmployeePageingAndSortingRepository employeePageingAndSortingRepository = null;


    @Before
    public void serup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeePageingAndSortingRepository = ctx.getBean(EmployeePageingAndSortingRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void page(){

        Pageable pageable = new PageRequest(1, 9);

        Page<Employee> page = employeePageingAndSortingRepository.findAll(pageable);

        System.out.println("页数：" + page.getTotalPages());
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("当前第几页：" + (page.getNumber() + 1));
        System.out.println("当前页面的集合：" + page.getContent().toString());
        System.out.println("当前页面的记录数：" + page.getNumberOfElements());
    }

    @Test
    public void pageAndSort(){

        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");

        Sort sort = new Sort(order);

        Pageable pageable = new PageRequest(1, 9, sort);

        Page<Employee> page = employeePageingAndSortingRepository.findAll(pageable);

        System.out.println("页数：" + page.getTotalPages());
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("当前第几页：" + (page.getNumber() + 1));
        System.out.println("当前页面的集合：" + page.getContent().toString());
        System.out.println("当前页面的记录数：" + page.getNumberOfElements());
    }

}