package com.dev.backend.modules.marca.service.novaMarca;

import com.dev.backend.modules.marca.dto.NovaMarcaRequestDTO;
import com.dev.backend.modules.marca.dto.NovaMarcaResponseDTO;
import com.dev.backend.modules.marca.entity.Marca;
import com.dev.backend.modules.marca.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;

@Service
public class NovaMarcaService {

    @Autowired
    private MarcaRepository marcaRepository;


    public NovaMarcaResponseDTO execute(@Valid NovaMarcaRequestDTO data){
        Marca marca = new Marca();
        marca.setNome(data.getNome());
        marca.setDataCriacao(new Date());
        marca.setDataAtualizacao(new Date());

        marcaRepository.saveAndFlush(marca);

        NovaMarcaResponseDTO response = new NovaMarcaResponseDTO();
        response.setNome(marca.getNome());

        return response;
    }

}
