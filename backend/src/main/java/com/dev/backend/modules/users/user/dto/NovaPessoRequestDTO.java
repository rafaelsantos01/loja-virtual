package com.dev.backend.modules.users.user.dto;

import com.dev.backend.modules.address.city.entity.Cidade;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import java.util.Date;

@Data
public class NovaPessoRequestDTO {


    private String nome;

    @CPF
    private String cpf;

    @Email
    private String email;

    private String senha;

    private String endereco;

    private String cep;

    private Date dataCriacao;

    private Date dataAtualizacao;

    private Long cidade;

}
