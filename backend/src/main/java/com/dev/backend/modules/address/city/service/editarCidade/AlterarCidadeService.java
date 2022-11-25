package com.dev.backend.modules.address.city.service.editarCidade;

import com.dev.backend.modules.address.city.dto.AtualizarCidadeRequestDTO;
import com.dev.backend.modules.address.city.dto.AtualizarCidadeResponseDTO;
import com.dev.backend.modules.address.city.entity.Cidade;
import com.dev.backend.modules.address.city.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Service
public class AlterarCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public AtualizarCidadeResponseDTO execute(Long id, @Valid AtualizarCidadeRequestDTO data) {
      Optional<Cidade> estadoBusca=  cidadeRepository.findById(id);

      if(estadoBusca.isEmpty()){
          throw new Error("Cidade não encontrado");
      }

      Cidade estado = estadoBusca.get();

      estado.setId(id);
      estado.setNome(data.getNome());
      estado.setDataAtualizacao(new Date());

        cidadeRepository.saveAndFlush(estado);

        AtualizarCidadeResponseDTO responseDTO = new AtualizarCidadeResponseDTO();
        responseDTO.setNome(estado.getNome());
        responseDTO.setDataAtualizacao(estado.getDataAtualizacao());
        responseDTO.setDataCriacao(estado.getDataCriacao());

        return responseDTO;
    }
}
