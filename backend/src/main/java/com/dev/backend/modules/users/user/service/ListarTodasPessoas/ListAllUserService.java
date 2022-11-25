package com.dev.backend.modules.users.user.service.ListarTodasPessoas;

import com.dev.backend.modules.users.user.dto.PessoaListDTO;
import com.dev.backend.modules.users.user.entity.Pessoa;
import com.dev.backend.modules.users.user.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListAllUserService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaListDTO> execute() {
        List<PessoaListDTO> response = new ArrayList<>();
        List<Pessoa> pessoas = pessoaRepository.findAll();

        for(Pessoa pessoa: pessoas){
            PessoaListDTO pessoaList = new PessoaListDTO();

            pessoaList.setId(pessoa.getId());
            pessoaList.setCep(pessoa.getCep());
            pessoaList.setCidade(pessoa.getCidade().getNome());
            pessoaList.setEmail(pessoa.getEmail());
            pessoaList.setEndereco(pessoa.getEndereco());
            pessoaList.setDataAtualizacao(pessoa.getDataAtualizacao());
            pessoaList.setDataCriacao(pessoa.getDataCriacao());
            pessoaList.setCpf(pessoa.getCpf());
            pessoaList.setSenha(pessoa.getSenha());


            response.add(pessoaList);
        }

        if(pessoas.isEmpty()){
            throw new Error("Lista de pessoas esta vazia");
        }

        return response;
    }
}
