package com.rjh.hrmanager.controllers;

import com.rjh.hrmanager.model.Employee;
import com.rjh.hrmanager.seeder.EmployeeSeeder;
import com.rjh.hrmanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        var employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws Throwable {
        var employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employeeData) {
        var employee = employeeService.addEmployee(employeeData);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PostMapping("/addMultiple")
    public ResponseEntity<List<Employee>> addEmployees(@RequestBody List<Employee> employeesData) {
        var employees = employeeService.addEmployees(employeesData);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employeeData) {
        var employee = employeeService.updateEmployee(employeeData);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/fakedata")
    public ResponseEntity<List<Employee>> getFakeEmployeeData() {
        return new ResponseEntity<>(EmployeeSeeder.GetFakeEmployees(), HttpStatus.OK);
    }
}
