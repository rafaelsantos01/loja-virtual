package com.dev.backend.modules.address.city.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class ListarTodasCidadesDTO implements Serializable {
    private  String nome;

    private Date dataCriacao;

    private Date dataAtualizacao;
}