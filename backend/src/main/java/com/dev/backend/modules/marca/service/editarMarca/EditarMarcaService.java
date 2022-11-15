package com.dev.backend.modules.marca.service.editarMarca;

import com.dev.backend.modules.marca.dto.NovaMarcaRequestDTO;
import com.dev.backend.modules.marca.dto.NovaMarcaResponseDTO;
import com.dev.backend.modules.marca.entity.Marca;
import com.dev.backend.modules.marca.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EditarMarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public NovaMarcaResponseDTO execute(Long id,NovaMarcaRequestDTO data){
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

        return responseDTO;
    }
}
