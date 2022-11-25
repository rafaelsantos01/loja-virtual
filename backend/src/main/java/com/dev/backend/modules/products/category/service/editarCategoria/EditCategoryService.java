package com.dev.backend.modules.products.category.service.editarCategoria;

import com.dev.backend.modules.products.category.dto.NovaCategoriaRequestDTO;
import com.dev.backend.modules.products.category.dto.NovaCategoriaResponseDTO;
import com.dev.backend.modules.products.category.entity.Categoria;
import com.dev.backend.modules.products.category.repository.CategoriaRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EditCategoryService {

    @Autowired
    private CategoriaRepositorty categoriaRepositorty;

    public NovaCategoriaResponseDTO execute(Long id, NovaCategoriaRequestDTO data){
        System.out.print(data.getNome());
        Optional<Categoria> categoria = categoriaRepositorty.findById(id);

        if(categoria.isEmpty()){
            throw new Error("Categoria não encontrada");
        }
        categoria.get().setNome(data.getNome());
        categoria.get().setDataAtualizacao(new Date());

        categoriaRepositorty.saveAndFlush(categoria.get());

        NovaCategoriaResponseDTO responseDTO = new NovaCategoriaResponseDTO();
        responseDTO.setNome(categoria.get().getNome());
        responseDTO.setId(categoria.get().getId());
        responseDTO.setDataAtualizacao(categoria.get().getDataAtualizacao());
        responseDTO.setDataCriacao(categoria.get().getDataCriacao());

        return responseDTO;
    }
}
