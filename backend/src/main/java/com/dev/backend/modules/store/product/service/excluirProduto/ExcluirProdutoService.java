package com.dev.backend.modules.store.product.service.excluirProduto;


import com.dev.backend.modules.store.product.entity.Produto;
import com.dev.backend.modules.store.product.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExcluirProdutoService {


    @Autowired
    private ProdutoRepository produtoRepository;


    public void execute(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);

        if(produto.isEmpty()){
            throw new Error("Produto não encontrado");
        }

        produtoRepository.delete(produto.get());

    }
}
