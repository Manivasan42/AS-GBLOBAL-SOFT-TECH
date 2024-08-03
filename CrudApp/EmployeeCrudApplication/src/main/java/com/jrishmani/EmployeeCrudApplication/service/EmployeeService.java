package com.jrishmani.EmployeeCrudApplication.service;

import java.util.List;

import com.jrishmani.EmployeeCrudApplication.entity.Employee;
import com.jrishmani.EmployeeCrudApplication.exception.ResourceNotFoundException;
import com.jrishmani.EmployeeCrudApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository emprepo;
    //get all employee details
    public List<Employee>getEmployeeDetails()
    {
        List<Employee>allEmployees=emprepo.findAll();
        return allEmployees;
    }

    //add all employee details
    public Employee saveOrUpdate(Employee employees)
    {
        return emprepo.save(employees);
    }

    //get particular data
    public Employee getEmployeeById1(Long id) {
        return emprepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
    }
//	public String saveOrUpdate(Employee employee,Long id, String firstName,String lastName,String email_id) {
//		emprepo.save(employee);
//		return "updated successfully";
//	}

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = emprepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail_id(employeeDetails.getEmail_id());

        Employee updatedEmployee = emprepo.save(employee);
        return updatedEmployee;
    }

    public void deleteEmployeeById(Long id) {
        // Check if the employee exists
        Employee existingEmployee = emprepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        // Perform the deletion
        emprepo.delete(existingEmployee);
    }



}