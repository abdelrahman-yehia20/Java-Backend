package com.example.task1.employee.mapper;


import com.example.task1.employee.dto.EmployeeDto;
import com.example.task1.employee.model.Employee;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
   Employee toEntity(EmployeeDto employeeDto);

//    @Mapping(source = "salary",target = "fullAddress")
//    @Mapping(target = "password", ignore = true)
    EmployeeDto toDto(Employee employee);
   List<Employee> toEntityList(List<EmployeeDto> employeeDtos);
    List<EmployeeDto> toDtoList(List<Employee> employees);
}
