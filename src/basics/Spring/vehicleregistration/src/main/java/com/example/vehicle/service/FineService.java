package com.example.vehicle.service;

import com.example.vehicle.dto.FineDto;

import java.util.List;

public interface FineService {

    List<FineDto> getOwnerFines(Long ownerId);

    FineDto payFine(Long fineId);
}
