package com.example.vehicle.service;

import com.example.vehicle.dto.VehicleDto;

import java.util.List;

public interface VehicleService {

    VehicleDto register(VehicleDto dto);

    VehicleDto approve(Long vehicleId);

    VehicleDto getById(Long id);

    List<VehicleDto> getByOwner(Long ownerId);
}
