package com.example.task1.Address.dto;

import com.example.task1.employee.model.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    private Long id;
    private String city;
    private String street;
}
