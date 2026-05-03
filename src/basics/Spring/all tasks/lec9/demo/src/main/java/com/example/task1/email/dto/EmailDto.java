package com.example.task1.email.dto;

import com.example.task1.employee.model.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDto {

    private Long id;

    @NotNull(message = "Name must not be null")
    @NotBlank(message = "Name must not be empty")
    private String name;

    @NotNull(message = "Email must not be null")
    @NotBlank(message = "Email must not be empty")
    @Email(message = "Email must be valid")
    private String content;

    private Employee employee;

}
