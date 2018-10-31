package com.jonas.repository;

import com.jonas.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Desc：
 * Author Jonas
 * 2018/10/30 17:33
 */
@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeRepository /*extends Repository<Employee, Integer> */{

    // 通过Jpa命名规则方式查询
    Employee findByName(String name);

    // where name like ?% and age <?
    List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    // where name like %? and age <?
    List<Employee> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    // where name in(?,?...) or age <?
    List<Employee> findByNameInOrAgeLessThan(List<String> name, Integer age);

    // where name in(?,?...) and age <?
    List<Employee> findByNameInAndAgeLessThan(List<String> name, Integer age);

    // 默认原生态查询（nativeQuery = false）为false，from后跟的是Employee 实体类名
    // 嵌套查询
    @Query("select e from Employee e where id=(select max(id) from Employee e2 )")
    Employee getEmployeeByMaxId();

    // 占位符方式查询（?1、?2）
    @Query("select e from Employee e where e.name=?1 and e.age=?2")
    List<Employee> queryParams1(String name, Integer age);

    // 命名参数方式（:name、:age）
    @Query("select e from Employee e where e.name=:name and e.age=:age")
    List<Employee> queryParams2(@Param("name") String name, @Param("age") Integer age);

    @Query("select e from Employee e where e.name like %?1%")
    List<Employee> queryLike1(String name);

    @Query("select e from Employee e where e.name like %:name%")
    List<Employee> queryLike2(@Param("name") String name);

    // 将原生态查询（nativeQuery = true）改为true，from后跟的就是mployee 数据库中的表名
    @Query(nativeQuery = true, value = "select count(1) from employee")
    long getCount();

    @Modifying
    @Query("update Employee e set e.age = :age where e.id = :id")
    void update(@Param("id") Integer id, @Param("age") Integer age);

}
