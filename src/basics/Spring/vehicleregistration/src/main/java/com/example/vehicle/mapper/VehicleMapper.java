package com.example.vehicle.mapper;

import com.example.vehicle.dto.UserDto;
import com.example.vehicle.dto.VehicleDto;
import com.example.vehicle.model.User;
import com.example.vehicle.model.Vehicle;
import org.mapstruct.Mapping;

import java.util.List;

public interface VehicleMapper {
    Vehicle toEntity(VehicleDto vehicleDto);

    @Mapping(source = "owner.id", target = "ownerId")
    @Mapping(source = "owner.fullName", target = "ownerName")
    VehicleDto toDto(Vehicle vehicle);

    List<Vehicle> toEntityList(List<VehicleDto> vehicleDtos);
    List<VehicleDto> toDtoList(List<Vehicle> vehicles);
}
