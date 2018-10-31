package com.jonas.repository;

import com.jonas.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Desc：
 * Author Jonas
 * 2018/10/31 11:10
 */
public interface EmployeePageingAndSortingRepository extends PagingAndSortingRepository<Employee, Integer> {
}
