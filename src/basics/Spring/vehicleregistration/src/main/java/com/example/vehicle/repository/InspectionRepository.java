package com.example.vehicle.repository;

import com.example.vehicle.model.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface InspectionRepository extends JpaRepository<Inspection, Long> {

    Optional<Inspection> findTopByVehicleIdOrderByInspectionDateDesc(Long vehicleId);

    List<Inspection> findByNextInspectionDateBefore(LocalDate date);
}
