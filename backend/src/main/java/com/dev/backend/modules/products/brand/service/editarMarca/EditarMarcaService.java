package com.dev.backend.modules.products.brand.service.editarMarca;

import com.dev.backend.modules.products.brand.dto.NovaMarcaRequestDTO;
import com.dev.backend.modules.products.brand.dto.NovaMarcaResponseDTO;
import com.dev.backend.modules.products.brand.entity.Marca;
import com.dev.backend.modules.products.brand.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EditarMarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public NovaMarcaResponseDTO execute(Long id, NovaMarcaRequestDTO data){
        System.out.print(data.getNome());
        Optional<Marca> marca = marcaRepository.findById(id);

        if(marca.isEmpty()){
            throw new Error("Marca não encontrada");
        }
        marca.get().setNome(data.getNome());
        marca.get().setDataAtualizacao(new Date());

        marcaRepository.saveAndFlush(marca.get());

        NovaMarcaResponseDTO responseDTO = new NovaMarcaResponseDTO();
        responseDTO.setNome(marca.get().getNome());
        responseDTO.setId(marca.get().getId());
        responseDTO.setDataAtualizacao(marca.get().getDataAtualizacao());
        responseDTO.setDataCriacao(marca.get().getDataCriacao());

        return responseDTO;
    }
}
