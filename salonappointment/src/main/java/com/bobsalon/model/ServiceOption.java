package com.bobsalon.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "service_options")
@Data
@NoArgsConstructor
public class ServiceOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private Double price;
    
    @Column(nullable = false, name = "duration_minutes")
    private Integer durationMinutes;
    
    // Add this constructor if you're not using Lombok's @AllArgsConstructor
    public ServiceOption(String name, String description, Double price, Integer durationMinutes) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.durationMinutes = durationMinutes;
    }
}