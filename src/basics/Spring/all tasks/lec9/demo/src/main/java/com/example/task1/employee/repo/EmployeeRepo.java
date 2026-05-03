package com.example.task1.employee.repo;

import com.example.task1.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    List<Employee> findByIdIn(List<Long> ids);
    List<Employee> findByNameIn(List<String> names);
}
