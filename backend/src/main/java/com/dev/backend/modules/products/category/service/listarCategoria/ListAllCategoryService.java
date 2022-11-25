package com.dev.backend.modules.products.category.service.listarCategoria;

import com.dev.backend.modules.products.category.dto.ListCategoriaResponseDTO;
import com.dev.backend.modules.products.category.entity.Categoria;
import com.dev.backend.modules.products.category.repository.CategoriaRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListAllCategoryService {

    @Autowired
    private CategoriaRepositorty categoriaRepositorty;

    public List<ListCategoriaResponseDTO> execute() {
        List<ListCategoriaResponseDTO> response = new ArrayList<>();

        List<Categoria> categorias = categoriaRepositorty.findAll();

        for(Categoria categoria: categorias){
            ListCategoriaResponseDTO list = new ListCategoriaResponseDTO();
            list.setNome(categoria.getNome());
            list.setId(categoria.getId());
            list.setDataAtualizacao(categoria.getDataAtualizacao());
            list.setDataCriacao(categoria.getDataCriacao());
            response.add(list);
        }

        if(response.isEmpty()){
            throw new Error("Lista de Categorias esta vazia");
        }

        return response;
    }
}
