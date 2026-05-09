package com.example.vehicle.service.impl;

import com.example.vehicle.dto.InspectionDto;
import com.example.vehicle.exception.ResourceNotFoundException;
import com.example.vehicle.mapper.InspectionMapper;
import com.example.vehicle.model.Inspection;
import com.example.vehicle.model.Vehicle;
import com.example.vehicle.repository.InspectionRepository;
import com.example.vehicle.repository.VehicleRepository;
import com.example.vehicle.service.InspectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InspectionServiceImpl implements InspectionService {

    private final InspectionRepository inspectionRepository;
    private final VehicleRepository vehicleRepository;
    private final InspectionMapper inspectionMapper;

    @Override
    public InspectionDto addInspection(Long vehicleId, InspectionDto dto) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle not found"));

        Inspection inspection = inspectionMapper.toEntity(dto);

        inspection.setInspectionDate(LocalDate.now());
        inspection.setNextInspectionDate(LocalDate.now().plusMonths(6));
        inspection.setVehicle(vehicle);

        return inspectionMapper.toDto(
                inspectionRepository.save(inspection));
    }

    @Override
    public List<InspectionDto> upcomingInspections() {
        return inspectionRepository
                .findByNextInspectionDateBefore(LocalDate.now().plusDays(7))
                .stream()
                .map(inspectionMapper::toDto)
                .toList();
    }
}
