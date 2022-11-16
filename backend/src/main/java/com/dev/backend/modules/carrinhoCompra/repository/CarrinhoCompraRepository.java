package com.dev.backend.modules.carrinhoCompra.repository;

import com.dev.backend.modules.carrinhoCompra.entity.CarrinhoCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompra, Long> {
}