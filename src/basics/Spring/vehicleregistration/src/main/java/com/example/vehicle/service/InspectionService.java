package com.example.vehicle.service;

import com.example.vehicle.dto.InspectionDto;

import java.util.List;

public interface InspectionService {

    InspectionDto addInspection(Long vehicleId, InspectionDto dto);

    List<InspectionDto> upcomingInspections();
}
