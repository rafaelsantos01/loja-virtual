package com.dev.backend.modules.cidade.service.novoCidade;

import com.dev.backend.modules.cidade.dto.NovaCidadeDTO;
import com.dev.backend.modules.cidade.entity.Cidade;
import com.dev.backend.modules.cidade.repository.CidadeRepository;
import com.dev.backend.modules.estado.dto.EstadoSalvarDTO;
import com.dev.backend.modules.estado.entity.Estado;
import com.dev.backend.modules.estado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Service
public class NovoCidadeService {

    @Autowired
    private CidadeRepository  cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;


    public Cidade execute(@Valid NovaCidadeDTO data) {
        Optional<Estado> estado=  estadoRepository.findById(data.getIdEstado());

        if(estado.isEmpty()){
            throw new Error("Estado não encontrado");
        }

        Cidade cidade = new Cidade();
        cidade.setNome(data.getNome());
        cidade.setDataCriacao(new Date());
        cidade.setDataAtualizacao(new Date());
        cidade.setEstado(estado.get());

        cidadeRepository.saveAndFlush(cidade);

        return cidade;
    }


}
