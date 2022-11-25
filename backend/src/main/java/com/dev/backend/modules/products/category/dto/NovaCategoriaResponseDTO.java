package com.dev.backend.modules.products.category.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NovaCategoriaResponseDTO {

    private Long id;

    private String nome;

    private Date dataCriacao;

    private Date dataAtualizacao;
}
