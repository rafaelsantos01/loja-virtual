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

@Service
public class NovoCidadeService {

    @Autowired
    private CidadeRepository  cidadeRepository;


    public Cidade execute(@Valid NovaCidadeDTO data) {

        Cidade estado = new Cidade();
        estado.setNome(data.getNome());
        estado.setDataCriacao(new Date());
        estado.setDataAtualizacao(new Date());

        cidadeRepository.saveAndFlush(estado);

        return estado;
    }


}
