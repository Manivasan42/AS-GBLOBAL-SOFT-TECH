package com.jrishmani.EmployeeCrudApplication.repository;

import com.jrishmani.EmployeeCrudApplication.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}