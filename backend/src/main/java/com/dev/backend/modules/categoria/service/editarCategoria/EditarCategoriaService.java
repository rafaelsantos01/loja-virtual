package com.dev.backend.modules.categoria.service.editarCategoria;

import com.dev.backend.modules.categoria.dto.NovaCategoriaRequestDTO;
import com.dev.backend.modules.categoria.dto.NovaCategoriaResponseDTO;
import com.dev.backend.modules.categoria.entity.Categoria;
import com.dev.backend.modules.categoria.repository.CategoriaRepositorty;
import com.dev.backend.modules.marca.dto.NovaMarcaRequestDTO;
import com.dev.backend.modules.marca.dto.NovaMarcaResponseDTO;
import com.dev.backend.modules.marca.entity.Marca;
import com.dev.backend.modules.marca.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EditarCategoriaService {

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

        return responseDTO;
    }
}
