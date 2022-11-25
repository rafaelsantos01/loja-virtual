package com.dev.backend.modules.products.Image.service.ListarTodasImagens;

import com.dev.backend.modules.products.Image.dto.ProductImageDto;
import com.dev.backend.modules.products.Image.entity.ProductImage;
import com.dev.backend.modules.products.Image.repository.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListarTodasImagensService {


    @Autowired
    private ProductImageRepository productImageRepository;

    public List<ProductImageDto> execute() {

        List<ProductImageDto> response = new ArrayList<>();
        List<ProductImage> imagens = productImageRepository.findAll();

        for(ProductImage imagem: imagens){
            ProductImageDto dto = new ProductImageDto();
            dto.setNome(imagem.getNome());
            dto.setProduto(imagem.getProduto());
            dto.setDataCriacao(imagem.getDataCriacao());
            dto.setDataAtualizacao(imagem.getDataAtualizacao());

            response.add(dto);
        }

        return response;
    }
}
