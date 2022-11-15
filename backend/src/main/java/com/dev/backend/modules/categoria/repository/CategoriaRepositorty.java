package com.dev.backend.modules.categoria.repository;

import com.dev.backend.modules.categoria.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorty extends JpaRepository<Categoria,Long> {
}
