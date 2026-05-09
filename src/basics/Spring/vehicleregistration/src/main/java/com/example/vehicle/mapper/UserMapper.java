package com.example.vehicle.mapper;

import com.example.vehicle.dto.UserDto;
import com.example.vehicle.model.User;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto userDto);
    UserDto toDto(User user);
    List<User> toEntityList(List<UserDto> userDtos);
    List<UserDto> toDtoList(List<User> users);
}
