package com.jonas.repository;

import com.jonas.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Desc：
 * Author Jonas
 * 2018/10/31 11:41
 */
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {
}
