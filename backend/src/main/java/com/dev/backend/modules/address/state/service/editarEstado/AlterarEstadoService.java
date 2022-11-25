package com.dev.backend.modules.address.state.service.editarEstado;

import com.dev.backend.modules.address.state.dto.EstadoRequestAtualizacaoDTO;
import com.dev.backend.modules.address.state.entity.Estado;
import com.dev.backend.modules.address.state.repository.EstadoRepository;
import com.dev.backend.modules.address.state.dto.EstadoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Service
public class AlterarEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public EstadoResponseDTO execute(Long id, @Valid EstadoRequestAtualizacaoDTO data) {
        Optional<Estado> estadoBusca=  estadoRepository.findById(id);

        if(estadoBusca.isEmpty()){
            throw new Error("Estado não encontrado");
        }

        Estado estado = estadoBusca.get();

        estado.setId(id);
        estado.setNome(data.getNome());
        estado.setSigla(data.getSigla());
        estado.setDataAtualizacao(new Date());

        estadoRepository.saveAndFlush(estado);

        EstadoResponseDTO responseDTO = new EstadoResponseDTO();
        responseDTO.setNome(estado.getNome());
        responseDTO.setSigla(estado.getSigla());
        responseDTO.setDataAtualizacao(estado.getDataAtualizacao());
        responseDTO.setDataCriacao(estado.getDataCriacao());

        return responseDTO;
    }
}
