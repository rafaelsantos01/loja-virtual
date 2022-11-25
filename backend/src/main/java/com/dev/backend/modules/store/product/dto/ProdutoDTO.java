package com.dev.backend.modules.store.product.dto;

import com.dev.backend.modules.products.brand.entity.Marca;
import com.dev.backend.modules.products.category.entity.Categoria;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProdutoDTO implements Serializable {


    private  String descricaoCurta;
    private  String descricaoDetalhada;
    private  Double valorCusto;
    private  Double valorVenda;
    private  Marca marca;
    private  Categoria categoria;
}