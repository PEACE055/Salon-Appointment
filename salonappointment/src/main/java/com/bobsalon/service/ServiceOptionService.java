package com.bobsalon.service;

import com.bobsalon.model.ServiceOption;
import com.bobsalon.repository.ServiceOptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceOptionService {
    private final ServiceOptionRepository serviceOptionRepository;
    
    public List<ServiceOption> getAllServiceOptions() {
        return serviceOptionRepository.findAllByOrderByNameAsc();
    }
    
    public ServiceOption createServiceOption(ServiceOption serviceOption) {
        return serviceOptionRepository.save(serviceOption);
    }
}
