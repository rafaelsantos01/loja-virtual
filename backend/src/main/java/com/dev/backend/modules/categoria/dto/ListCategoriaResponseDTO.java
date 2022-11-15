package com.dev.backend.modules.categoria.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ListCategoriaResponseDTO {

    @NotBlank
    @NotNull
    @NotEmpty
    private String nome;
}
