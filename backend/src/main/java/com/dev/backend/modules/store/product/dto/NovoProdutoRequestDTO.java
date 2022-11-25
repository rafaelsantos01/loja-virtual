package com.dev.backend.modules.store.product.dto;

import com.dev.backend.modules.products.brand.entity.Marca;
import com.dev.backend.modules.products.category.entity.Categoria;
import lombok.Data;

@Data
public class NovoProdutoRequestDTO {


    private  String descricaoCurta;
    private  String descricaoDetalhada;
    private  Double valorCusto;
    private  Double valorVenda;
    private  Long marca;
    private  Long categoria;
}
