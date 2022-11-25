package com.dev.backend.modules.products.brand.repository;

import com.dev.backend.modules.products.brand.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Long> {
}
