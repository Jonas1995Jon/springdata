package com.jonas.repository;

import com.jonas.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Desc：
 * Author Jonas
 * 2018/10/31 10:55
 */
public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {
}
