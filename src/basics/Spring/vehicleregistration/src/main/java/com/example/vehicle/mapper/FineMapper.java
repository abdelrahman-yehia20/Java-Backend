package com.example.vehicle.mapper;

import com.example.vehicle.dto.FineDto;
import com.example.vehicle.model.Fine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FineMapper {

    @Mapping(source = "owner.id", target = "ownerId")
    @Mapping(source = "owner.fullName", target = "ownerName")
    FineDto toDto(Fine fine);

    Fine toEntity(FineDto dto);
}
