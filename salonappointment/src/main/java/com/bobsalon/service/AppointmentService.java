package com.bobsalon.service;

import com.bobsalon.dto.AppointmentRequestDTO;
import com.bobsalon.dto.AppointmentResponseDTO;
import com.bobsalon.exception.ResourceNotFoundException;
import com.bobsalon.model.Appointment;
import com.bobsalon.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;
    
    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO requestDTO) {
        Appointment appointment = modelMapper.map(requestDTO, Appointment.class);
        appointment.setStatus("PENDING");
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return modelMapper.map(savedAppointment, AppointmentResponseDTO.class);
    }
    
    @Transactional(readOnly = true)
    public List<AppointmentResponseDTO> getAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public AppointmentResponseDTO getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + id));
        return convertToDTO(appointment);
    }
    
    @Transactional(readOnly = true)
    public List<AppointmentResponseDTO> getAppointmentsByEmail(String email) {
        return appointmentRepository.findByEmail(email).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public void cancelAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + id));
        appointment.setStatus("CANCELLED");
        appointmentRepository.save(appointment);
    }
    
    @Transactional(readOnly = true)
    public List<AppointmentResponseDTO> getAvailableTimeSlots(LocalDateTime date) {
        LocalDateTime start = date.withHour(9).withMinute(0).withSecond(0);
        LocalDateTime end = date.withHour(17).withMinute(0).withSecond(0);
        
        return appointmentRepository.findByAppointmentDateTimeBetween(start, end).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    private AppointmentResponseDTO convertToDTO(Appointment appointment) {
        return modelMapper.map(appointment, AppointmentResponseDTO.class);
    }
}