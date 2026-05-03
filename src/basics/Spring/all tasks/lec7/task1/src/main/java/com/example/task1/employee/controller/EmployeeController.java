package com.example.task1.employee.controller;

import com.example.task1.employee.model.Employee;
import com.example.task1.employee.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService= employeeService;
    }


    @GetMapping("Employees")
    public List<Employee> getEmployee(){
        return employeeService.getEmployees();
    }
    @GetMapping("Employees/by-ids")
    public List<Employee> getEmployeesByIds(@RequestBody List<Long> ids){
        return employeeService.getEmployeesByIds(ids);
    }

    @PostMapping("save")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PostMapping("saveList")
    public List<Employee> createListOfEmployees(@RequestBody List<Employee> employees){
        return employeeService.createListOfEmployee(employees);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @PutMapping("/updateList")
    public List<Employee> updateListOfEmployee(@RequestBody List<Employee> employees){
        return employeeService.updateListOfEmployee(employees);
    }

    @DeleteMapping("delete/id/{id}")
    public void removeEmployeeById(@PathVariable("id") Long id){
        employeeService.removeEmployeeById(id);
    }

    @Transactional
    @DeleteMapping("/delete")
    public void removeEmployeeById(@RequestParam List<Long> ids){
        employeeService.removeListOfEmployeeById(ids);
    }

    @DeleteMapping("/deleteAll")
    public void removeAllEmployee(){
        employeeService.removeAllEmployee();
    }

    @GetMapping("/Employees/search")
    public List<Employee> searchByName(@RequestParam String name){
       return employeeService.searchByName(name);
    }
}
