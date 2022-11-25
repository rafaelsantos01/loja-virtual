package com.dev.backend.modules.store.carBuy.repository;

import com.dev.backend.modules.store.carBuy.entity.CarrinhoCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompra, Long> {
}