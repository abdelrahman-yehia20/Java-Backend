package com.example.vehicle.service.impl;

import com.example.vehicle.dto.LicenseDto;
import com.example.vehicle.enums.FineStatus;
import com.example.vehicle.exception.BusinessException;
import com.example.vehicle.exception.ResourceNotFoundException;
import com.example.vehicle.mapper.LicenseMapper;
import com.example.vehicle.model.Fine;
import com.example.vehicle.model.Inspection;
import com.example.vehicle.model.License;
import com.example.vehicle.model.Vehicle;
import com.example.vehicle.repository.FineRepository;
import com.example.vehicle.repository.InspectionRepository;
import com.example.vehicle.repository.VehicleRepository;
import com.example.vehicle.service.LicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LicenseServiceImpl implements LicenseService {
    private final VehicleRepository vehicleRepository;
    private final InspectionRepository inspectionRepository;
    private final FineRepository fineRepository;
    private final LicenseMapper licenseMapper;

    @Override
    public LicenseDto renew(Long vehicleId) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle not found"));

        Inspection inspection = inspectionRepository
                .findTopByVehicleIdOrderByInspectionDateDesc(vehicleId)
                .orElseThrow(() ->
                        new BusinessException("No inspection found"));

        if (inspection.getInspectionDate().isBefore(LocalDate.now().minusMonths(6))){
            throw new BusinessException("Inspection expired");
        }
        License license = vehicle.getLicense();
        if (license.getExpiryDate().isBefore(LocalDate.now())){
            Fine fine = Fine.builder()
                    .amount(500.0)
                    .reason("Late renewal")
                    .fineDate(LocalDate.now())
                    .status(FineStatus.UNPAID)
                    .owner(vehicle.getOwner())
                    .build();

            fineRepository.save(fine);
        }

        license.setIssueDate(LocalDate.now());
        license.setExpiryDate(LocalDate.now().minusYears(1));
        return licenseMapper.toDto(license);
    }

    @Override
    public LicenseDto getVehicleLicense(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle not found"));

        return licenseMapper.toDto(vehicle.getLicense());
    }

    @Override
    public List<LicenseDto> getExpiredLicenses() {
        return vehicleRepository.findAll()
                .stream()
                .map(Vehicle::getLicense)
                .filter(license -> license.getExpiryDate().isBefore(LocalDate.now()))
                .map(licenseMapper::toDto)
                .toList();
    }
}
