package com.jonas.repository;

import com.jonas.domain.Employee;
import org.junit.After;
import org.junit.Assert;
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
 * 2018/10/30 17:36
 */
public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;

    private EmployeeRepository employeeRepository = null;


    @Before
    public void serup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void findByName() {

        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println("id：" + employee.getId() +
                " name：" + employee.getName() +
                " age：" + employee.getAge());
    }

    @Test
    public void findByNameStartingWithAndAgeLessThan() {

        List<Employee> lists = employeeRepository.findByNameStartingWithAndAgeLessThan("test", 34);

        for (Employee employee : lists) {
            System.out.println("id：" + employee.getId() +
                    " name：" + employee.getName() +
                    " age：" + employee.getAge());
        }

    }

    @Test
    public void findByNameEndingWithAndAgeLessThan() {

        List<Employee> lists = employeeRepository.findByNameEndingWithAndAgeLessThan("6", 35);

        for (Employee employee : lists) {
            System.out.println("id：" + employee.getId() +
                    " name：" + employee.getName() +
                    " age：" + employee.getAge());
        }

    }

    @Test
    public void findByNameInOrAgeLessThan() {

        ArrayList<String> names = new ArrayList<>();
        names.add("test1");
        names.add("test2");
        names.add("test3");

        List<Employee> lists = employeeRepository.findByNameInOrAgeLessThan(names, 25);

        for (Employee employee : lists) {
            System.out.println("id：" + employee.getId() +
                    " name：" + employee.getName() +
                    " age：" + employee.getAge());
        }

    }

    @Test
    public void findByNameInAndAgeLessThan() {

        ArrayList<String> names = new ArrayList<>();
        names.add("test1");
        names.add("test2");
        names.add("test3");

        List<Employee> lists = employeeRepository.findByNameInAndAgeLessThan(names, 30);

        for (Employee employee : lists) {
            System.out.println("id：" + employee.getId() +
                    " name：" + employee.getName() +
                    " age：" + employee.getAge());
        }

    }

    @Test
    public void getEmployeeByMaxId() {

        Employee employee = employeeRepository.getEmployeeByMaxId();

        System.out.println("id：" + employee.getId() +
                " name：" + employee.getName() +
                " age：" + employee.getAge());
    }

    @Test
    public void queryParams1() {

        List<Employee> lists = employeeRepository.queryParams1("zhangsan", 35);

        for (Employee employee : lists) {
            System.out.println("id：" + employee.getId() +
                    " name：" + employee.getName() +
                    " age：" + employee.getAge());
        }
    }

    @Test
    public void queryParams2() {

        List<Employee> lists = employeeRepository.queryParams2("zhangsan", 35);

        for (Employee employee : lists) {
            System.out.println("id：" + employee.getId() +
                    " name：" + employee.getName() +
                    " age：" + employee.getAge());
        }
    }

    @Test
    public void queryLike1() {

        List<Employee> lists = employeeRepository.queryLike1("test");

        for (Employee employee : lists) {
            System.out.println("id：" + employee.getId() +
                    " name：" + employee.getName() +
                    " age：" + employee.getAge());
        }
    }

    @Test
    public void queryLike2() {

        List<Employee> lists = employeeRepository.queryLike2("test1");

        for (Employee employee : lists) {
            System.out.println("id：" + employee.getId() +
                    " name：" + employee.getName() +
                    " age：" + employee.getAge());
        }
    }

    @Test
    public void getCount() {

        long count = employeeRepository.getCount();

        System.out.println("count：" + count);
    }
}