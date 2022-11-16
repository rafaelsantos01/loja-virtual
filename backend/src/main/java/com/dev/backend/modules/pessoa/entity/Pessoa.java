package com.dev.backend.modules.pessoa.entity;

import com.dev.backend.modules.cidade.entity.Cidade;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Getter
@Setter

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CPF
    private String cpf;

    @Email
    private String email;

    private String senha;

    private String endereco;

    private String cep;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    @ManyToOne
    @JoinColumn(name="idCidade")
    private Cidade cidade;



}
