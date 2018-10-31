package com.jonas.dao;

import com.jonas.domain.Student;

import java.util.List;

/**
 * Desc：StudentDao访问接口
 * Author Jonas
 * 2018/10/30 15:13
 */
public interface StudentDao {

    /**
     * 查询所有学生
     * @return 所有学生
     */
    public List<Student> query();

    /**
     * 添加一个学生
     * @param student
     */
    public void save(Student student);

}
