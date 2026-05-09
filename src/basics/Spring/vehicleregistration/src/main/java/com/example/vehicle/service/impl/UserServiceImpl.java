package com.example.vehicle.service.impl;

import com.example.vehicle.dto.UserDto;
import com.example.vehicle.exception.ResourceNotFoundException;
import com.example.vehicle.mapper.UserMapper;
import com.example.vehicle.model.User;
import com.example.vehicle.repository.UserRepository;
import com.example.vehicle.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserDto create(UserDto dto) {

        User user = userMapper.toEntity(dto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtoList(users);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
