package com.example.vehicle.controller;

import com.example.vehicle.dto.FineDto;
import com.example.vehicle.service.FineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fines")
@RequiredArgsConstructor
public class FineController {

    private final FineService fineService;

    @GetMapping("/{ownerId}")
    public List<FineDto> ownerFines(
            @PathVariable Long ownerId) {

        return fineService.getOwnerFines(ownerId);
    }

    @PostMapping("/pay/{fineId}")
    public FineDto payFine(@PathVariable Long fineId) {

        return fineService.payFine(fineId);
    }
}
