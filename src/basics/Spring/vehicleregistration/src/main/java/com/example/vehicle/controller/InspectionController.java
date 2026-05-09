package com.example.vehicle.controller;

import com.example.vehicle.dto.InspectionDto;
import com.example.vehicle.service.InspectionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inspections")
@RequiredArgsConstructor
public class InspectionController {

    private final InspectionService inspectionService;

    @PostMapping("/{vehicleId}")
    public InspectionDto addInspection(
            @PathVariable Long vehicleId,
            @Valid @RequestBody InspectionDto dto) {

        return inspectionService.addInspection(vehicleId, dto);
    }

    @GetMapping("/upcoming")
    public List<InspectionDto> upcoming() {

        return inspectionService.upcomingInspections();
    }
}