package com.example.vehicle.model;

import com.example.vehicle.enums.FineStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String reason;

    @Enumerated(EnumType.STRING)
    private FineStatus status;

    private LocalDate fineDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}