package com.example.task1.employee.service.impl;

import com.example.task1.employee.dto.EmployeeDto;
import com.example.task1.employee.mapper.EmployeeMapper;
import com.example.task1.employee.model.Employee;
import com.example.task1.employee.repo.EmployeeRepo;
import com.example.task1.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepo employeeRepo;
    EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo,EmployeeMapper employeeMapper ){
        this.employeeRepo = employeeRepo;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEntity(employeeDto);
        if (employee.getAddresses() != null) {
            employee.getAddresses().forEach(a -> a.setEmployee(employee));
        }
        Employee savedEmployee = employeeRepo.save(employee);
        return employeeMapper.toDto(savedEmployee);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEntity(employeeDto);
        employee = employeeRepo.save(employee);
        return employeeDto;
    }


    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employeeMapper.toDtoList(employees);
    }

    @Override
    public List<EmployeeDto> getEmployeesByIds(List<Long> ids) {
        List<Employee> employees = employeeRepo.findByIdIn(ids);
        return employeeMapper.toDtoList(employees);
    }

    @Override
    public List<EmployeeDto> getEmployeesByNames(List<String> names) {
        List<Employee> employees = employeeRepo.findByNameIn(names);
        return employeeMapper.toDtoList(employees);
    }

    @Override
    public void removeEmployeeById(long id) {
        employeeRepo.deleteById(id);
    }








}
