package com.jonas.repository;

import com.jonas.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Desc：
 * Author Jonas
 * 2018/10/31 11:50
 */
public interface EmployeeJpaSpecificationExecutorRepository
        extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
}
