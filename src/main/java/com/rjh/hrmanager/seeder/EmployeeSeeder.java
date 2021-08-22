package com.rjh.hrmanager.seeder;

import com.github.javafaker.Faker;
import com.rjh.hrmanager.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSeeder {
    public static List<Employee> GetFakeEmployees() {
        List<Employee> employees = new ArrayList<>();
        Faker faker = new Faker();
        for(int i = 0; i < 8; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            employees.add(new Employee(
                    firstName,
                    lastName,
                    firstName + lastName + "@gmail.com".strip(),
                    faker.job().position(),
                    faker.job().field(),
                    faker.phoneNumber().cellPhone(),
                    "https://bootdey.com/img/Content/avatar/avatar" + (i+1) + ".png"));
        }
        return employees;
    }
}
