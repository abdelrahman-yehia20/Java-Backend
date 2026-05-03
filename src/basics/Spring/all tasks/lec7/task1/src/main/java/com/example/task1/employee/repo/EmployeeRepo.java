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
    void deleteByIdIn(List<Long> ids);
    List<Employee> findByNameStartingWith(String name);

    @Query(value = "SELECT * FROM employee WHERE name LIKE :name", nativeQuery = true)
    List<Employee> searchByNameNative(@Param("name") String name);
}
