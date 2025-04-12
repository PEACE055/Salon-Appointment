package com.bobsalon.controller;

import com.bobsalon.model.ServiceOption;
import com.bobsalon.repository.ServiceOptionRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceOptionController {
    
    private final ServiceOptionRepository serviceRepo;

    public ServiceOptionController(ServiceOptionRepository serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    @GetMapping
    public List<ServiceOption> getAllServices() {
        return serviceRepo.findAllByOrderByNameAsc();
    }
}