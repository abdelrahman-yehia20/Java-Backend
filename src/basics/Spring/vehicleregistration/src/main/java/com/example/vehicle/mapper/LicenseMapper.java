package com.example.vehicle.mapper;

import com.example.vehicle.dto.LicenseDto;
import com.example.vehicle.model.License;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LicenseMapper {

    @Mapping(source = "vehicle.id", target = "vehicleId")
    @Mapping(source = "vehicle.plateNumber", target = "plateNumber")
    @Mapping(
            expression = "java(license.getExpiryDate().isBefore(java.time.LocalDate.now()))",
            target = "expired"
    )
    LicenseDto toDto(License license);

    License toEntity(LicenseDto dto);
}
