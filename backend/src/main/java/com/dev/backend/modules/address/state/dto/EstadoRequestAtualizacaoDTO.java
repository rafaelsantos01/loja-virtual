package com.dev.backend.modules.address.state.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class EstadoRequestAtualizacaoDTO {


    @NotEmpty @NotBlank @NotNull
    private String nome;

    @NotEmpty @NotBlank @NotNull
    private String sigla;

}
