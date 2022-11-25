package com.dev.backend.modules.users.user.service.excluirPessoa;

import com.dev.backend.modules.users.user.entity.Pessoa;
import com.dev.backend.modules.users.user.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteUserService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public void execute(Long id){

        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        if(pessoa.isEmpty()){
            throw new Error("Nenhuma pessoa com esse id encontrado");
        }

        pessoaRepository.delete(pessoa.get());
    }
}
