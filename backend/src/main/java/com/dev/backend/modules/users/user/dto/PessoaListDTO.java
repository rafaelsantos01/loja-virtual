package com.dev.backend.modules.users.user.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PessoaListDTO {

    private Long id;

    private String cpf;

    private String email;

    private String senha;

    private String endereco;

    private String cep;

    private Date dataCriacao;

    private Date dataAtualizacao;

    private String cidade;
}
