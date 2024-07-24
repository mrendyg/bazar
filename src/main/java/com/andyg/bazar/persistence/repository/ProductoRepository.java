package com.andyg.bazar.persistence.repository;

import com.andyg.bazar.persistence.model.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
}
