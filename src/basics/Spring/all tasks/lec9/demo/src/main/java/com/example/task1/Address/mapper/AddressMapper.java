package com.example.task1.Address.mapper;

import com.example.task1.Address.dto.AddressDto;
import com.example.task1.Address.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toEntity(AddressDto dto);
    AddressDto toDto(Address entity);
}
