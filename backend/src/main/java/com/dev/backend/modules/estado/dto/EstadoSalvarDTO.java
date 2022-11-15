package com.dev.backend.modules.estado.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class EstadoSalvarDTO {

    @NotNull
    @NotBlank
    @NotEmpty
    private String nome;

    @NotNull
    @NotBlank
    @NotEmpty
    private String sigla;

}
