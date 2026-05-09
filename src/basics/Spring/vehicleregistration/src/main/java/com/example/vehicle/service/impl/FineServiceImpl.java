package com.example.vehicle.service.impl;

import com.example.vehicle.dto.FineDto;
import com.example.vehicle.enums.FineStatus;
import com.example.vehicle.exception.ResourceNotFoundException;
import com.example.vehicle.mapper.FineMapper;
import com.example.vehicle.model.Fine;
import com.example.vehicle.repository.FineRepository;
import com.example.vehicle.service.FineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FineServiceImpl implements FineService {

    private final FineRepository fineRepository;
    private final FineMapper fineMapper;

    @Override
    public List<FineDto> getOwnerFines(Long ownerId) {

        return fineRepository.findByOwnerId(ownerId)
                .stream()
                .map(fineMapper::toDto)
                .toList();
    }

    @Override
    public FineDto payFine(Long fineId) {
        Fine fine = fineRepository.findById(fineId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Fine not found"));

        fine.setStatus(FineStatus.PAID);

        return fineMapper.toDto(fineRepository.save(fine));

    }
}
