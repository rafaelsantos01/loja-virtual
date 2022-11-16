package com.dev.backend.modules.produto.entity;


import com.dev.backend.modules.categoria.entity.Categoria;
import com.dev.backend.modules.marca.entity.Marca;
import com.dev.backend.modules.pessoa.entity.Pessoa;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="produto")
public class Produto {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricaoCurta;

    private String descricaoDetalhada;

    private Double valorCusto;

    private Double valorVenda;

    @ManyToOne
    @JoinColumn(name="idMarca")
    private Marca marca;


    @ManyToOne
    @JoinColumn(name="idCategoria")
    private Categoria categoria;


    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
