package com.jonas.dao.impl;

import com.jonas.dao.StudentDao;
import com.jonas.domain.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Desc：
 * Author Jonas
 * 2018/10/30 15:25
 */
public class StudentDaoImplTest {

    StudentDao studentDao = new StudentDaoImpl();

    @Test
    public void query() {

        List<Student> students = studentDao.query();

        for (Student student : students) {
            System.out.println("id：" + student.getId() + " name：" + student.getName() + " age：" + student.getAge());
        }


    }

    @Test
    public void save() {

        Student student = new Student();
        student.setName("test");
        student.setAge(30);

        studentDao.save(student);

    }
}