package com.dev.backend.modules.cidade.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AtualizarCidadeResponseDTO {


    private String nome;

    private Date dataCriacao;

    private Date dataAtualizacao;
}
