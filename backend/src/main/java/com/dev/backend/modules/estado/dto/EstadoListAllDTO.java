package com.dev.backend.modules.estado.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EstadoListAllDTO {

    private Long id;

    private String nome;

    private String sigla;

    private Date dataCriacao;

    private Date dataAtualizacao;
}
