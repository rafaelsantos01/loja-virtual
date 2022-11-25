package com.dev.backend.modules.address.state.service.excluirEstado;

import com.dev.backend.modules.address.state.entity.Estado;
import com.dev.backend.modules.address.state.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
