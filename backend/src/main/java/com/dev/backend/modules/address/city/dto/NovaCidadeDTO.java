package com.dev.backend.modules.address.city.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class NovaCidadeDTO {

    @NotEmpty @NotNull @NotBlank
    private String nome;

    private Long idEstado;
}