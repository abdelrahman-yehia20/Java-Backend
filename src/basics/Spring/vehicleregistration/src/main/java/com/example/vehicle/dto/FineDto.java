package com.example.vehicle.dto;

import com.example.vehicle.enums.FineStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FineDto {

    private Long id;

    private Double amount;

    private String reason;

    private FineStatus status;

    private LocalDate fineDate;

    private Long ownerId;

    private String ownerName;
}
