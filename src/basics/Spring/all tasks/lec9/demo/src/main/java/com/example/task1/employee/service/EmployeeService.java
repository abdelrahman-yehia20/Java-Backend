package com.example.task1.employee.service;

import com.example.task1.employee.dto.EmployeeDto;
import com.example.task1.employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getEmployees();
    List<EmployeeDto> getEmployeesByIds(List<Long> ids);
    List<EmployeeDto> getEmployeesByNames(List<String> name);
    void removeEmployeeById(long id);


//    void  removeListOfEmployeeById(List<Long> ids);
//    void removeAllEmployee();
//    List<Employee> searchByName(String name);
//    List<Employee> createListOfEmployee(List<Employee> employees);
//    List<Employee> updateListOfEmployee(List<Employee> employees);


}
