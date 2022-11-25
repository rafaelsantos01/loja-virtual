package com.dev.backend.modules.products.brand.service.novaMarca;

import com.dev.backend.modules.products.brand.dto.NovaMarcaRequestDTO;
import com.dev.backend.modules.products.brand.dto.NovaMarcaResponseDTO;
import com.dev.backend.modules.products.brand.entity.Marca;
import com.dev.backend.modules.products.brand.repository.MarcaRepository;
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

        Marca marcaResponse = marcaRepository.saveAndFlush(marca);

        NovaMarcaResponseDTO response = new NovaMarcaResponseDTO();
        response.setNome(marcaResponse.getNome());
        response.setId(marcaResponse.getId());
        response.setDataCriacao(marcaResponse.getDataCriacao());
        response.setDataAtualizacao(marcaResponse.getDataAtualizacao());

        return response;
    }

}
