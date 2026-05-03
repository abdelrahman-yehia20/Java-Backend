package com.example.task1.employee.controller;

import com.example.task1.employee.dto.EmployeeDto;
import com.example.task1.employee.model.Employee;
import com.example.task1.employee.service.EmployeeService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class EmployeeController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService= employeeService;
    }

// ResponseEntity<Void>  ResponseEntity<TeacherDto>  ResponseEntity<List<TeacherDto>>
    @GetMapping("Employees")
    public ResponseEntity<List<EmployeeDto>> getEmployee(){
        return ResponseEntity.ok(employeeService.getEmployees());
    }
    @GetMapping("Employees/by-ids")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByIds(@RequestBody List<Long> ids){
        return ResponseEntity.ok(employeeService.getEmployeesByIds(ids));
    }

    @GetMapping("Employees/by-names")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByNames(@RequestBody List<String> names){
        return ResponseEntity.ok(employeeService.getEmployeesByNames(names));
    }


    @PostMapping("save")
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/save")).body(employeeService.createEmployee(employeeDto));

    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDto> updateEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDto));
    }

    @DeleteMapping("delete/id/{id}")
    public ResponseEntity<Void> removeEmployeeById(@PathVariable("id") Long id){
        employeeService.removeEmployeeById(id);
       return ResponseEntity.notFound().build() ;
    }

}
