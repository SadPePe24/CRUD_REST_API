package com.kissmepls.spring.rest.controller;

import com.kissmepls.spring.rest.entity.Employee;
import com.kissmepls.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController
{
    @Autowired
    private EmployeeService employeeService;

    // Получение всех работников
    @GetMapping("/employees")
    public List<Employee> showAllEmployees()
    {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }
}
