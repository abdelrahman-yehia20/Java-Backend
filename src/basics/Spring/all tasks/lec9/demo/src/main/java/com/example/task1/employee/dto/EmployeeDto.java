package com.example.task1.employee.dto;

import com.example.task1.email.model.Email;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {
    private Long id;


    @NotNull(message = "Name must not be null")
    @NotBlank(message = "Name must not be empty")
    private String name;

    @NotNull(message = "Age must not be null")
    @Min(value = 16, message = "Age must be greater than 15")
    @Max(value = 39, message = "Age must be less than 40")
    private int age;

    @NotNull(message = "Salary must not be null")
    @DecimalMin(value = "5000.0", inclusive = false, message = "Salary must be greater than 5000")
    @DecimalMax(value = "10000.0", inclusive = false, message = "Salary must be less than 10000")
    private float salary;
    private List<Email> emails;

}
