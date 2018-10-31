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
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

import static org.junit.Assert.*;

/**
 * Desc：
 * Author Jonas
 * 2018/10/31 11:52
 */
public class EmployeeJpaSpecificationExecutorRepositoryTest {

    private ApplicationContext ctx = null;

    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository = null;


    @Before
    public void serup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaSpecificationExecutorRepository = ctx.getBean(EmployeeJpaSpecificationExecutorRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    /**
     * 分页
     * 排序
     * 查询条件
     */
    @Test
    public void query(){

        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);

        Pageable pageable = new PageRequest(0, 5, sort);

        /**
         * root：就是我们要查询的类型（Employee）
         * query：添加查询条件
         * cb：构建Predicate
         */
        Specification<Employee> specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {

                Path path = root.get("age");
                return cb.gt(path, 50);
            }
        };

        Page<Employee> page = employeeJpaSpecificationExecutorRepository.findAll(specification, pageable);

        System.out.println("页数：" + page.getTotalPages());
        System.out.println("总记录数：" + page.getTotalElements());
        System.out.println("当前第几页：" + (page.getNumber() + 1));
        System.out.println("当前页面的集合：" + page.getContent().toString());
        System.out.println("当前页面的记录数：" + page.getNumberOfElements());

    }

}