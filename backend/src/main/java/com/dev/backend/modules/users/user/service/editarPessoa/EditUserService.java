package com.dev.backend.modules.users.user.service.editarPessoa;


import com.dev.backend.modules.address.city.entity.Cidade;
import com.dev.backend.modules.address.city.repository.CidadeRepository;
import com.dev.backend.modules.users.user.dto.NovaPessoRequestDTO;
import com.dev.backend.modules.users.user.dto.NovaPessoaResponseDTO;
import com.dev.backend.modules.users.user.entity.Pessoa;
import com.dev.backend.modules.users.user.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EditUserService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CidadeRepository cidadeRepository;


    public NovaPessoaResponseDTO execute(Long id,NovaPessoRequestDTO data){
        Optional<Pessoa> user = pessoaRepository.findById(id);
       // Cidade cidade = cidadeRepository.findById(data.getCidade()).orElse(new Cidade());

        if(user.isEmpty()){
            throw new Error("Usuário não encontrado");
        }
        user.get().setId(user.get().getId());
        user.get().setCpf(data.getCpf());
        user.get().setCep(data.getCep());
        user.get().setEmail(data.getEmail());
        user.get().setEndereco(data.getEndereco());
        user.get().setSenha(data.getSenha());
        user.get().setDataAtualizacao(new Date());
        user.get().setNome(data.getNome());

        Pessoa userSave = pessoaRepository.saveAndFlush(user.get());


        NovaPessoaResponseDTO response = new NovaPessoaResponseDTO();
        response.setEndereco(userSave.getEndereco());
        response.setCidade(userSave.getCidade().getNome());
        response.setCpf(userSave.getCpf());
        response.setId(userSave.getId());
        response.setDataAtualizacao(userSave.getDataAtualizacao());
        response.setDataCriacao(userSave.getDataCriacao());
        response.setCep(userSave.getCep());
        response.setNome(userSave.getNome());
        response.setEmail(userSave.getEmail());
        response.setSenha(userSave.getSenha());

        return response;
    }
}
