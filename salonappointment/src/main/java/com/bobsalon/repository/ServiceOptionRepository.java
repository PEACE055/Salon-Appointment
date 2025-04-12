package com.bobsalon.repository;

import com.bobsalon.model.ServiceOption;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServiceOptionRepository extends JpaRepository<ServiceOption, Long> {
    List<ServiceOption> findAllByOrderByNameAsc();
}