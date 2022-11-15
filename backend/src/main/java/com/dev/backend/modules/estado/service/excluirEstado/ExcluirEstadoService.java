package com.dev.backend.modules.estado.service.excluirEstado;

import com.dev.backend.modules.estado.dto.EstadoRequestAtualizacaoDTO;
import com.dev.backend.modules.estado.dto.EstadoResponseDTO;
import com.dev.backend.modules.estado.entity.Estado;
import com.dev.backend.modules.estado.repository.EstadoRepository;
import com.dev.backend.modules.estado.service.editarEstado.AlterarEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Service
public class ExcluirEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public void execute(Long id) {
        Optional<Estado> estadoBusca = estadoRepository.findById(id);

        if (estadoBusca.isEmpty()) {
            throw new Error("Estado não encontrado");
        }
        estadoRepository.delete(estadoBusca.get());
    }
}
