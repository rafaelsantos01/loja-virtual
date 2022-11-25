package com.dev.backend.modules.address.state.service.novoEstado;

import com.dev.backend.modules.address.state.dto.EstadoSalvarDTO;
import com.dev.backend.modules.address.state.entity.Estado;
import com.dev.backend.modules.address.state.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;

@Service
public class NovoEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;


    public Estado execute(@Valid EstadoSalvarDTO data) {

        Estado estado = new Estado();
        estado.setNome(data.getNome());
        estado.setSigla(data.getSigla());
        estado.setDataCriacao(new Date());
        estado.setDataAtualizacao(new Date());

        estadoRepository.saveAndFlush(estado);

        return estado;
    }


}
