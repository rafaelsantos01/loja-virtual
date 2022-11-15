package com.dev.backend.modules.cidade.service.excluirCidade;

import com.dev.backend.modules.cidade.entity.Cidade;
import com.dev.backend.modules.cidade.repository.CidadeRepository;
import com.dev.backend.modules.estado.entity.Estado;
import com.dev.backend.modules.estado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExcluirCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public void execute(Long id) {
        Optional<Cidade> cidade = cidadeRepository.findById(id);

        if (cidade.isEmpty()) {
            throw new Error("Cidade não encontrado");
        }
        cidadeRepository.delete(cidade.get());
    }
}
