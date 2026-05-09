package com.example.vehicle.model;

import com.example.vehicle.enums.VehicleStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String plateNumber;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    private Integer manufactureYear;

    @Enumerated(EnumType.STRING)
    private VehicleStatus status;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private License license;

    @OneToMany(mappedBy = "vehicle")
    private List<Inspection> inspections;
}
