package com.dev.backend.modules.address.city.service.excluirCidade;

import com.dev.backend.modules.address.city.entity.Cidade;
import com.dev.backend.modules.address.city.repository.CidadeRepository;
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
