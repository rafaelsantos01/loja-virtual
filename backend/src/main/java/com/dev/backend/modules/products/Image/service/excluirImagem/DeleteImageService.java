package com.dev.backend.modules.products.Image.service.excluirImagem;

import com.dev.backend.modules.products.Image.entity.ProductImage;
import com.dev.backend.modules.products.Image.repository.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteImageService {


    @Autowired
    private ProductImageRepository productImageRepository;


    public void execute(Long id) {
        Optional<ProductImage> image = productImageRepository.findById(id);

        if (image.isEmpty()) {
            throw new Error("Imagem não encontrada");
        }
        productImageRepository.delete(image.get());

    }

}
