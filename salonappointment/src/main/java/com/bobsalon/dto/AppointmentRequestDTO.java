package com.bobsalon.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequestDTO {
    @NotBlank(message = "Customer name is required")
    private String customerName;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
    
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Phone number should be between 10-15 digits")
    private String phone;
    
    @NotBlank(message = "Service type is required")
    private String serviceType;
    
    @Future(message = "Appointment date must be in the future")
    private LocalDateTime appointmentDateTime;
}
