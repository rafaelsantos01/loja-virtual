package com.dev.backend.modules.estado.dto;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class EstadoResponseDTO {

    private String nome;

    private String sigla;

    private Date dataCriacao;

    private Date dataAtualizacao;
}
