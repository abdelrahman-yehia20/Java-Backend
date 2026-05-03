package com.example.task1.email.mapper;


import com.example.task1.email.dto.EmailDto;
import com.example.task1.email.model.Email;
import com.example.task1.employee.dto.EmployeeDto;
import com.example.task1.employee.model.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailMapper {
   Email toEntity(EmailDto emailDto);
   EmailDto toDto(Email email);
   List<Email> toEntityList(List<EmailDto> emailDtos);
   List<EmailDto> toDtoList(List<Email> emails);
}
