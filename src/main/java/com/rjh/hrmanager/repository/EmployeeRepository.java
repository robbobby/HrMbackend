package com.rjh.hrmanager.repository;

import com.rjh.hrmanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    void deleteEmployeeById(Long id);
    List<Employee> findAllByDepartment(String department);

    Optional<Employee> findEmployeeById(Long id);
}
