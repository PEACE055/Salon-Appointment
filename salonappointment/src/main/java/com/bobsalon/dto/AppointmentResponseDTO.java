package com.bobsalon.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponseDTO {
    private Long id;
    private String customerName;
    private String email;
    private String phone;
    private String serviceType;
    private LocalDateTime appointmentDateTime;
    private LocalDateTime createdAt;
    private String status;
}
