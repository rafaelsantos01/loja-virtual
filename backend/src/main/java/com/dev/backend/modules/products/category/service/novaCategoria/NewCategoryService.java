package com.dev.backend.modules.products.category.service.novaCategoria;

import com.dev.backend.modules.products.category.dto.NovaCategoriaRequestDTO;
import com.dev.backend.modules.products.category.dto.NovaCategoriaResponseDTO;
import com.dev.backend.modules.products.category.entity.Categoria;
import com.dev.backend.modules.products.category.repository.CategoriaRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;

@Service
public class NewCategoryService {

    @Autowired
    private CategoriaRepositorty categoriaRepositorty;


    public NovaCategoriaResponseDTO execute(@Valid NovaCategoriaRequestDTO data){
        Categoria marca = new Categoria();
        marca.setNome(data.getNome());
        marca.setDataCriacao(new Date());
        marca.setDataAtualizacao(new Date());

        categoriaRepositorty.saveAndFlush(marca);

        NovaCategoriaResponseDTO response = new NovaCategoriaResponseDTO();
        response.setNome(marca.getNome());
        response.setId(marca.getId());
        response.setDataAtualizacao(marca.getDataAtualizacao());
        response.setDataCriacao(marca.getDataCriacao());

        return response;
    }

}
