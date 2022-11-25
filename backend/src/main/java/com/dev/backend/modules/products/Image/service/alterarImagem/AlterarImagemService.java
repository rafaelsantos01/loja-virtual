package com.dev.backend.modules.products.Image.service.alterarImagem;


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
public class AlterarImagemService {

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private ProdutoRepository produtoRepository;


    public ProductImageDto execute(Long id, CreateImageRequestDTO data) {
        Optional<ProductImage> imagem = productImageRepository.findById(id);
        Optional<Produto> produto = produtoRepository.findById(data.getProduto());

        if(imagem.isEmpty()){
            throw new Error("Imagem não encontrada");
        }

        ProductImage image = imagem.get();
        image.setId(id);
        image.setNome(data.getNome());
        image.setProduto(produto.get());
        image.setDataAtualizacao(new Date());

        productImageRepository.saveAndFlush(image);

        ProductImageDto response = new ProductImageDto();
        response.setNome(image.getNome());
        response.setProduto(image.getProduto());
        response.setDataCriacao(image.getDataCriacao());
        response.setDataAtualizacao(image.getDataAtualizacao());

        return response;

    }
}
