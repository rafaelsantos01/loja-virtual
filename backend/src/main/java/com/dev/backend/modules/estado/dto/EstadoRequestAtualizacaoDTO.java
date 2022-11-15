package com.dev.backend.modules.estado.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
public class EstadoRequestAtualizacaoDTO {


    @NotEmpty @NotBlank @NotNull
    private String nome;

    @NotEmpty @NotBlank @NotNull
    private String sigla;

}
