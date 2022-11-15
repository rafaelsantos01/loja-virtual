package com.dev.backend.modules.cidade.service.listarTodos;

import com.dev.backend.modules.cidade.dto.ListarTodasCidadesDTO;
import com.dev.backend.modules.cidade.entity.Cidade;
import com.dev.backend.modules.cidade.repository.CidadeRepository;
import com.dev.backend.modules.estado.dto.EstadoListAllDTO;
import com.dev.backend.modules.estado.entity.Estado;
import com.dev.backend.modules.estado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListarTodasCidadesService {

    @Autowired
    private CidadeRepository cidadeRepository;


    public List<ListarTodasCidadesDTO> execute() {
        List<ListarTodasCidadesDTO> response = new ArrayList<>();

        List<Cidade> all = cidadeRepository.findAll();

        if (all.isEmpty()) {
            throw new Error("A lista de cidade esta vazia.");
        }

        for (Cidade cidade : all) {
            ListarTodasCidadesDTO list = new ListarTodasCidadesDTO();
            list.setNome(cidade.getNome());
            list.setDataAtualizacao(cidade.getDataAtualizacao());
            list.setDataCriacao(cidade.getDataCriacao());
            response.add(list);
        }

        return response;
    }
}
