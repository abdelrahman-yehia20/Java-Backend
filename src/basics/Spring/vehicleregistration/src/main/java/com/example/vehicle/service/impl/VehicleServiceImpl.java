package com.example.vehicle.service.impl;

import com.example.vehicle.dto.VehicleDto;
import com.example.vehicle.enums.VehicleStatus;
import com.example.vehicle.exception.BusinessException;
import com.example.vehicle.exception.ResourceNotFoundException;
import com.example.vehicle.mapper.VehicleMapper;
import com.example.vehicle.model.License;
import com.example.vehicle.model.User;
import com.example.vehicle.model.Vehicle;
import com.example.vehicle.repository.UserRepository;
import com.example.vehicle.repository.VehicleRepository;
import com.example.vehicle.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final VehicleMapper vehicleMapper;

    @Override
    public VehicleDto register(VehicleDto dto) {

        if (vehicleRepository.existsByPlateNumber(dto.getPlateNumber())) {
            throw new BusinessException("Plate number already exists");
        }
        User owner = userRepository.findById(dto.getOwnerId()).orElseThrow(()->new ResourceNotFoundException("Owner not found"));
        Vehicle vehicle = vehicleMapper.toEntity(dto);
        vehicle.setOwner(owner);
        vehicle.setStatus(VehicleStatus.PENDING);
        return vehicleMapper.toDto(vehicleRepository.save(vehicle));
    }

    @Override
    public VehicleDto approve(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(()->new ResourceNotFoundException("Vehicle not found"));
        vehicle.setStatus(VehicleStatus.APPROVED);
        License license = License.builder().
                            issueDate(LocalDate.now()).
                            expiryDate(LocalDate.now().plusYears(1)).
                            vehicle(vehicle).build();
        vehicle.setLicense(license);


        return vehicleMapper.toDto(vehicleRepository.save(vehicle));
    }

    @Override
    public VehicleDto getById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Vehicle not found"));
        return vehicleMapper.toDto(vehicle);
    }

    @Override
    public List<VehicleDto> getByOwner(Long ownerId) {
        List<Vehicle> vehicles = vehicleRepository.findByOwnerId(ownerId);
        return vehicleMapper.toDtoList(vehicles);
    }
}
