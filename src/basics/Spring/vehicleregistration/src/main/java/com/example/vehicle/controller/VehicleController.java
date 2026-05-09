package com.example.vehicle.controller;

import com.example.vehicle.dto.VehicleDto;
import com.example.vehicle.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping("/register")
    public VehicleDto register(
            @Valid @RequestBody VehicleDto dto) {

        return vehicleService.register(dto);
    }

    @PutMapping("/{id}/approve")
    public VehicleDto approve(@PathVariable Long id) {

        return vehicleService.approve(id);
    }

    @GetMapping("/{id}")
    public VehicleDto getById(@PathVariable Long id) {

        return vehicleService.getById(id);
    }

    @GetMapping("/owner/{ownerId}")
    public List<VehicleDto> getByOwner(
            @PathVariable Long ownerId) {

        return vehicleService.getByOwner(ownerId);
    }
}