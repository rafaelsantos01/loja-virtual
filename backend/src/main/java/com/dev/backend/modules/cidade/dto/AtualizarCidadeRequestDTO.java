package com.dev.backend.modules.cidade.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AtualizarCidadeRequestDTO {
    @NotEmpty
    @NotNull
    @NotBlank
    private String nome;
}
