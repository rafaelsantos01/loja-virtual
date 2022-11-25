package com.dev.backend.modules.products.brand.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NovaMarcaResponseDTO {

    private Long id;

    private String nome;

    private Date dataCriacao;

    private Date dataAtualizacao;
}
