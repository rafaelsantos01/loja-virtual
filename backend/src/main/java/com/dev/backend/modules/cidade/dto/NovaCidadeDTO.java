package com.dev.backend.modules.cidade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class NovaCidadeDTO {

    @NotEmpty @NotNull @NotBlank
    private String nome;

    private Long idEstado;
}