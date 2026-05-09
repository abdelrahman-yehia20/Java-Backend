package com.example.vehicle.mapper;

import com.example.vehicle.dto.InspectionDto;
import com.example.vehicle.model.Inspection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InspectionMapper {

    @Mapping(source = "vehicle.id", target = "vehicleId")
    @Mapping(source = "vehicle.plateNumber", target = "plateNumber")
    InspectionDto toDto(Inspection inspection);

    Inspection toEntity(InspectionDto dto);
}