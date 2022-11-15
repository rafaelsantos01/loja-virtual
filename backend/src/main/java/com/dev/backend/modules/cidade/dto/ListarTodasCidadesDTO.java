package com.dev.backend.modules.cidade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


@Data
public class ListarTodasCidadesDTO implements Serializable {
    private  String nome;

    private Date dataCriacao;

    private Date dataAtualizacao;
}