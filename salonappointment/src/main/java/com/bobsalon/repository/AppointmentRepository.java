package com.bobsalon.repository;

import com.bobsalon.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByEmail(String email);
    
    List<Appointment> findByAppointmentDateTimeBetween(LocalDateTime start, LocalDateTime end);
    
    // Add this if you need to find by status
    List<Appointment> findByStatus(String status);
}