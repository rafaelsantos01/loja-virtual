package com.dev.backend.modules.products.Image.service.novaImagem;


import com.dev.backend.modules.products.Image.dto.CreateImageRequestDTO;
import com.dev.backend.modules.products.Image.dto.ProductImageDto;
import com.dev.backend.modules.products.Image.entity.ProductImage;
import com.dev.backend.modules.products.Image.repository.ProductImageRepository;
import com.dev.backend.modules.store.product.entity.Produto;
import com.dev.backend.modules.store.product.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CreateImageService {

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProductImageDto execute(CreateImageRequestDTO data) {
        Optional<Produto> produto = produtoRepository.findById(data.getProduto());

        if(produto.isEmpty()){
            throw new Error("Produto não encontrado");
        }

        ProductImage image = new ProductImage();
        image.setNome(data.getNome());
        image.setProduto(produto.get());
        image.setDataAtualizacao(new Date());
        image.setDataCriacao(new Date());

        productImageRepository.saveAndFlush(image);

        ProductImageDto response = new ProductImageDto();
        response.setNome(image.getNome());
        response.setProduto(produto.get());
        response.setDataAtualizacao(image.getDataAtualizacao());
        response.setDataCriacao(image.getDataCriacao());


        return response;
    }
}
