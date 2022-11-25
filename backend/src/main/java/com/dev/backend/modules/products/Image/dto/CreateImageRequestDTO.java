package com.dev.backend.modules.products.Image.dto;

import com.dev.backend.modules.store.product.entity.Produto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class CreateImageRequestDTO {

    @NotBlank @NotNull @NotEmpty
    private  String nome;
    @NotBlank @NotNull @NotEmpty
    private Long produto;
}
