package com.dev.backend.modules.store.product.service.novoProduto;

import com.dev.backend.modules.products.brand.entity.Marca;
import com.dev.backend.modules.products.brand.repository.MarcaRepository;
import com.dev.backend.modules.products.category.entity.Categoria;
import com.dev.backend.modules.products.category.repository.CategoriaRepositorty;
import com.dev.backend.modules.store.product.dto.ProdutoDTO;
import com.dev.backend.modules.store.product.dto.NovoProdutoRequestDTO;
import com.dev.backend.modules.store.product.entity.Produto;
import com.dev.backend.modules.store.product.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class NovoProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepositorty categoriaRepositorty;

    @Autowired
    private MarcaRepository marcaRepository;


    public ProdutoDTO execute(NovoProdutoRequestDTO data) {
        ProdutoDTO response = new ProdutoDTO();

        Optional<Categoria> categoria = categoriaRepositorty.findById(data.getCategoria());
        Optional<Marca> marca = marcaRepository.findById(data.getMarca());

        if(categoria.isEmpty() || marca.isEmpty()){
            throw new Error("Categoria ou marca não encontrada");
        }

        Produto produto = new Produto();

        produto.setValorCusto(data.getValorCusto());
        produto.setValorVenda(data.getValorVenda());
        produto.setDataAtualizacao(new Date());
        produto.setDataCriacao(new Date());
        produto.setMarca(marca.get());
        produto.setCategoria(categoria.get());
        produto.setDescricaoCurta(data.getDescricaoCurta());
        produto.setDescricaoDetalhada(data.getDescricaoDetalhada());

        produtoRepository.save(produto);

        response.setCategoria(produto.getCategoria());
        response.setMarca(produto.getMarca());
        response.setValorVenda(produto.getValorVenda());
        response.setValorCusto(produto.getValorCusto());
        response.setDescricaoDetalhada(produto.getDescricaoDetalhada());
        response.setDescricaoCurta(produto.getDescricaoCurta());

        return response;
    }
}
