package com.example.vehicle.repository;

import com.example.vehicle.model.License;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LicenseRepository extends JpaRepository<License, Long> {

    List<License> findByExpiryDateBefore(LocalDate date);
}
