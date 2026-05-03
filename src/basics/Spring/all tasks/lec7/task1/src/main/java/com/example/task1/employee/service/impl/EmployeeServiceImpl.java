package com.example.task1.employee.service.impl;

import com.example.task1.employee.model.Employee;
import com.example.task1.employee.repo.EmployeeRepo;
import com.example.task1.employee.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepo employeeRepo;
    public EmployeeServiceImpl(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }
    @Override
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employee> getEmployeesByIds(List<Long> ids) {
        return employeeRepo.findByIdIn(ids);
    }

    @Override
    public List<Employee> createListOfEmployee(List<Employee> employees) {
        return employeeRepo.saveAll(employees);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> updateListOfEmployee(List<Employee> employees) {
        return employeeRepo.saveAll(employees);
    }

    @Override
    public void removeEmployeeById(long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public void removeListOfEmployeeById(List<Long> ids) {
        employeeRepo.deleteByIdIn(ids);
    }

    @Override
    public void removeAllEmployee() {
        employeeRepo.deleteAll();
    }

    @Override
    public List<Employee> searchByName(String name) {
        return employeeRepo.findByNameStartingWith(name);
        // for native query
//        return employeeRepo.searchByNameNative(name);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }




}
