package com.dev.backend.modules.store.product.service.listarProduto;

import com.dev.backend.modules.store.product.dto.ProdutoDTO;
import com.dev.backend.modules.store.product.entity.Produto;
import com.dev.backend.modules.store.product.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListarTodosProdutosService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public List<ProdutoDTO> execute(){
        List<ProdutoDTO> response = new ArrayList<>();
        List<Produto> produtos = produtoRepository.findAll();

        for(Produto produto: produtos) {
            ProdutoDTO prod = new ProdutoDTO();
            prod.setMarca(produto.getMarca());
            prod.setDescricaoCurta(produto.getDescricaoCurta());
            prod.setDescricaoDetalhada(produto.getDescricaoDetalhada());
            prod.setValorCusto(produto.getValorCusto());
            prod.setValorVenda(produto.getValorVenda());
            prod.setCategoria(produto.getCategoria());

            response.add(prod);
        }

        return response;
    }
}
