package com.example.vehicle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String fullName;

        @Column(nullable = false, unique = true)
        private String nationalId;

        @Column(nullable = false, unique = true)
        private String email;

        @OneToMany(mappedBy = "owner")
        private List<Vehicle> vehicles;

        @OneToMany(mappedBy = "owner")
        private List<Fine> fines;
}
