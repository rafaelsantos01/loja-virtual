package com.dev.backend.modules.products.Image.repository;

import com.dev.backend.modules.products.Image.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}