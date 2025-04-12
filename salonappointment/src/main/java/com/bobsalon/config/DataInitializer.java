package com.bobsalon.config;

import com.bobsalon.model.ServiceOption;
import com.bobsalon.repository.ServiceOptionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    @Transactional
    public CommandLineRunner initData(ServiceOptionRepository serviceRepo) {
        return args -> {
            // Only initialize if database is empty
            if (serviceRepo.count() == 0) {
                List<ServiceOption> services = Arrays.asList(
                    createServiceOption("Haircut & Styling", 
                        "Trendy haircuts, blowouts, and styles tailored to your face shape", 
                        45.00, 60),
                    createServiceOption("Facials & Skin Care", 
                        "Glowing skin treatments that rejuvenate and refresh your face", 
                        75.00, 90),
                    createServiceOption("Manicure & Pedicure", 
                        "Pamper your hands and feet with our relaxing nail care services", 
                        60.00, 60)
                );
                serviceRepo.saveAll(services);
                System.out.println("Initialized database with " + services.size() + " services");
            }
        };
    }

    private ServiceOption createServiceOption(String name, String description, 
                                           Double price, Integer durationMinutes) {
        ServiceOption service = new ServiceOption();
        service.setName(name);
        service.setDescription(description);
        service.setPrice(price);
        service.setDurationMinutes(durationMinutes);
        return service;
    }
}