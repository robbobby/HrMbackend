package com.rjh.hrmanager.service;

import com.rjh.hrmanager.exception.UserNotFoundException;
import com.rjh.hrmanager.model.Employee;
import com.rjh.hrmanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    public List<Employee> getAllEmployeesInDepartment(String department) {
        return employeeRepository.findAllByDepartment(department);
    }

    public Employee findEmployeeById(Long id) throws Throwable {
        return employeeRepository.findEmployeeById(id).orElseThrow(() ->
                new UserNotFoundException("User by id " + id + " not found"));
    }

    public List<Employee> addEmployees(List<Employee> employeesData) {
        return employeeRepository.saveAll(employeesData);
    }
}
