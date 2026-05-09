package com.example.vehicle.controller;

import com.example.vehicle.dto.LicenseDto;
import com.example.vehicle.service.LicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licenses")
@RequiredArgsConstructor
public class LicenseController {

    private final LicenseService licenseService;

    @PostMapping("/renew/{vehicleId}")
    public LicenseDto renew(@PathVariable Long vehicleId) {

        return licenseService.renew(vehicleId);
    }

    @GetMapping("/{vehicleId}")
    public LicenseDto getVehicleLicense(
            @PathVariable Long vehicleId) {

        return licenseService.getVehicleLicense(vehicleId);
    }

    @GetMapping("/expired")
    public List<LicenseDto> expiredLicenses() {

        return licenseService.getExpiredLicenses();
    }
}