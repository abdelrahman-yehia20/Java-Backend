package com.example.vehicle.dto;

import com.example.vehicle.enums.VehicleStatus;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDto {

    private Long id;

    @NotBlank(message = "Plate number is required")
    private String plateNumber;

    @NotBlank(message = "Brand is required")
    private String brand;

    @NotBlank(message = "Model is required")
    private String model;

    @Min(1980)
    @Max(2030)
    private Integer manufactureYear;

    private VehicleStatus status;

    @NotNull(message = "Owner ID is required")
    private Long ownerId;

    private String ownerName;
}
