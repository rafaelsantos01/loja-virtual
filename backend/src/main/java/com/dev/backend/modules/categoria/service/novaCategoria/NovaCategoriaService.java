package com.dev.backend.modules.categoria.service.novaCategoria;

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

import javax.validation.Valid;
import java.util.Date;

@Service
public class NovaCategoriaService {

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

        return response;
    }

}
