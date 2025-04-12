package com.bobsalon.controller;

import com.bobsalon.model.Appointment;
import com.bobsalon.repository.AppointmentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    
    private final AppointmentRepository appointmentRepo;

    public AppointmentController(AppointmentRepository appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        appointment.setStatus("PENDING");
        return appointmentRepo.save(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }
}