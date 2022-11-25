package com.dev.backend.modules.store.product.repository;

import com.dev.backend.modules.store.product.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}