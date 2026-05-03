package com.example.task1.employee.model;

import com.example.task1.Address.model.Address;
import com.example.task1.email.model.Email;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private Integer age;

    private Float salary;

    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    private List<Email> emails;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Address> addresses ;

}
