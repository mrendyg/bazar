package com.andyg.bazar.persistence.repository;

import com.andyg.bazar.persistence.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
