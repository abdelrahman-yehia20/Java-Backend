
package com.example.vehicle.repository;

import com.example.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    boolean existsByPlateNumber(String plateNumber);

    List<Vehicle> findByOwnerId(Long ownerId);
}
