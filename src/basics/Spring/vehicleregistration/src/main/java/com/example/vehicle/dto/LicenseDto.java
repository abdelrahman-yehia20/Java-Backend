package com.example.vehicle.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LicenseDto {

    private Long id;

    private LocalDate issueDate;

    private LocalDate expiryDate;

    private Long vehicleId;

    private String plateNumber;

    private Boolean expired;
}
