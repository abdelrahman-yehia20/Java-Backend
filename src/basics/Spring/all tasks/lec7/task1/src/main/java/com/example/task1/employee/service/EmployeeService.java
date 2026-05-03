package com.example.task1.employee.service;

import com.example.task1.employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployees();
    public Employee createEmployee(Employee employee);
    List<Employee> getEmployeesByIds(List<Long> ids);
    List<Employee> createListOfEmployee(List<Employee> employees);
    Employee updateEmployee(Employee employee);
    List<Employee> updateListOfEmployee(List<Employee> employees);
    void removeEmployeeById(long id);
    void  removeListOfEmployeeById(List<Long> ids);
    void removeAllEmployee();
    List<Employee> searchByName(String name);

}
