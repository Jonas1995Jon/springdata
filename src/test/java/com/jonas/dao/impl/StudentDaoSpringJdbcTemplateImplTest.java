package com.jonas.dao.impl;

import com.jonas.dao.StudentDao;
import com.jonas.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Desc：
 * Author Jonas
 * 2018/10/30 16:37
 */
public class StudentDaoSpringJdbcTemplateImplTest {

    private ApplicationContext ctx = null;

    private StudentDao studentDao = null;

    @Before
    public void serup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDao = (StudentDao) ctx.getBean("studentDao");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void query() {

        List<Student> students = studentDao.query();

        for (Student student : students) {
            System.out.println("id：" + student.getId() +
                    " name：" + student.getName() +
                    " age：" + student.getAge());
        }


    }

    @Test
    public void save() {

        Student student = new Student();
        student.setName("test-spring-jdbc");
        student.setAge(40);

        studentDao.save(student);

    }
}