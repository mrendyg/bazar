package com.andyg.bazar.persistence.repository;

import com.andyg.bazar.persistence.model.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<VentaEntity, Long> {
}
