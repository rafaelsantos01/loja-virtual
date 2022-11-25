package com.dev.backend.modules.products.Image.dto;

import com.dev.backend.modules.store.product.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProductImageDto implements Serializable {


    private  String nome;
    private Produto produto;
    private  Date dataCriacao;
    private  Date dataAtualizacao;
}