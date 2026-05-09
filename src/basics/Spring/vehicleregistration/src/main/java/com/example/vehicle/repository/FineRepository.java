package com.example.vehicle.repository;

import com.example.vehicle.model.Fine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FineRepository extends JpaRepository<Fine, Long> {

    List<Fine> findByOwnerId(Long ownerId);
}
