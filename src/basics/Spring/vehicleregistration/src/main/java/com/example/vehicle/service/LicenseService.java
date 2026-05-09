package com.example.vehicle.service;

import com.example.vehicle.dto.LicenseDto;

import java.util.List;

public interface LicenseService {

    LicenseDto renew(Long vehicleId);

    LicenseDto getVehicleLicense(Long vehicleId);

    List<LicenseDto> getExpiredLicenses();
}
