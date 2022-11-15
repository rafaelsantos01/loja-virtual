package com.dev.backend.modules.estado.service.listarTodos;

import com.dev.backend.modules.estado.dto.EstadoListAllDTO;
import com.dev.backend.modules.estado.dto.EstadoResponseDTO;
import com.dev.backend.modules.estado.entity.Estado;
import com.dev.backend.modules.estado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListarTodosEstadosService {

    @Autowired
    private EstadoRepository estadoRepository;


    public List<EstadoListAllDTO> execute() {
        List<EstadoListAllDTO> response = new ArrayList<>();

        List<Estado> all = estadoRepository.findAll();

        if (all.isEmpty()) {
            throw new Error("A lista de estado esta vazia.");
        }

        for (Estado estado : all) {
            EstadoListAllDTO list = new EstadoListAllDTO();
            list.setNome(estado.getNome());
            list.setSigla(estado.getSigla());
            list.setDataAtualizacao(estado.getDataAtualizacao());
            list.setDataCriacao(estado.getDataCriacao());
            list.setId(estado.getId());
            response.add(list);
        }

        return response;
    }
}
