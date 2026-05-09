package com.example.vehicle.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InspectionDto {

    private Long id;

    private LocalDate inspectionDate;

    private LocalDate nextInspectionDate;

    @NotNull
    private Boolean passed;

    private Long vehicleId;

    private String plateNumber;
}
