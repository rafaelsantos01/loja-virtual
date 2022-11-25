package com.dev.backend.modules.store.product.service.editarProduto;

import com.dev.backend.modules.products.brand.entity.Marca;
import com.dev.backend.modules.products.brand.repository.MarcaRepository;
import com.dev.backend.modules.products.category.entity.Categoria;
import com.dev.backend.modules.products.category.repository.CategoriaRepositorty;
import com.dev.backend.modules.store.product.dto.NovoProdutoRequestDTO;
import com.dev.backend.modules.store.product.dto.ProdutoDTO;
import com.dev.backend.modules.store.product.entity.Produto;
import com.dev.backend.modules.store.product.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EditarProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private CategoriaRepositorty categoriaRepositorty;

    public ProdutoDTO execute(Long id,NovoProdutoRequestDTO data){
        Optional<Produto> prod = produtoRepository.findById(id);

        Optional<Marca> marca = marcaRepository.findById(data.getMarca());
        Optional<Categoria> categoria = categoriaRepositorty.findById(data.getCategoria());

        if(marca.isEmpty()){
            throw new Error("Marca não encontrado");
        }
        if(categoria.isEmpty()){
            throw new Error("Categoria não encontrado");
        }
        if(prod.isEmpty()){
            throw new Error("Produto não encontrado");
        }

        Produto produto = prod.get();

        produto.setId(produto.getId());
        produto.setMarca(marca.get());
        produto.setCategoria(categoria.get());
        produto.setDescricaoCurta(data.getDescricaoCurta());
        produto.setDescricaoDetalhada(data.getDescricaoDetalhada());
        produto.setValorVenda(data.getValorVenda());
        produto.setValorCusto(data.getValorCusto());
        produto.setDataAtualizacao(new Date());

        produtoRepository.save(produto);

        ProdutoDTO response = new ProdutoDTO();
        response.setCategoria(produto.getCategoria());
        response.setMarca(produto.getMarca());
        response.setDescricaoCurta(produto.getDescricaoCurta());
        response.setDescricaoDetalhada(produto.getDescricaoDetalhada());
        response.setValorVenda(produto.getValorVenda());
        response.setValorCusto(produto.getValorCusto());

        return response;
    }
}
