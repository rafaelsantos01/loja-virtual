package com.dev.backend.modules.products.brand.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class NovaMarcaRequestDTO {

    @NotBlank @NotNull @NotEmpty
    private String nome;
}
