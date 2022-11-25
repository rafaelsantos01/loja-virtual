package com.dev.backend.modules.store.carBuy.entity;

import com.dev.backend.modules.users.user.entity.Pessoa;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="carrinhoCompra")
public class CarrinhoCompra {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String observacao;

    private String situacao;

    @ManyToOne
    @JoinColumn(name="idPessoa")
    private Pessoa pessoa;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCompra;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
