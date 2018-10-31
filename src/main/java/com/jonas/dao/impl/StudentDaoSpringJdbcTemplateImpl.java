package com.jonas.dao.impl;

import com.jonas.dao.StudentDao;
import com.jonas.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc：
 * Author Jonas
 * 2018/10/30 16:25
 */
public class StudentDaoSpringJdbcTemplateImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> query() {
        final List<Student> students = new ArrayList<>();
        String sql = "select * from student";

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {

                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));

                students.add(student);
            }
        });

        return students;
    }

    @Override
    public void save(Student student) {

        String sql = "insert into student(name, age) values(?,?)";
        jdbcTemplate.update(sql, new Object[]{student.getName(), student.getAge()});

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
