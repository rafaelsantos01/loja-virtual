package com.dev.backend.modules.users.user.service.novaPessoa;

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
public class NewUserService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CidadeRepository cidadeRepository;


    public NovaPessoaResponseDTO execute(NovaPessoRequestDTO data){
        Optional<Cidade> cidade = cidadeRepository.findById(data.getCidade());

        Pessoa pessoa = new Pessoa();

        pessoa.setNome(data.getNome());
        pessoa.setCep(data.getCep());
        pessoa.setCidade(cidade.get());
        pessoa.setCpf(data.getCpf());
        pessoa.setEmail(data.getEmail());
        pessoa.setDataAtualizacao(new Date());
        pessoa.setDataCriacao(new Date());
        pessoa.setEndereco(data.getEndereco());
        pessoa.setSenha(data.getSenha());

        Pessoa pessoaSave = pessoaRepository.save(pessoa);

        NovaPessoaResponseDTO response = new NovaPessoaResponseDTO();
        response.setNome(pessoa.getNome());
        response.setCep(pessoa.getCep());
        response.setCidade(pessoa.getCidade().getNome());
        response.setCpf(pessoa.getCpf());
        response.setEmail(pessoa.getEmail());
        response.setDataAtualizacao(pessoa.getDataAtualizacao());
        response.setDataCriacao(pessoa.getDataCriacao());
        response.setSenha(pessoa.getSenha());
        response.setId(pessoaSave.getId());
        response.setEndereco(pessoaSave.getEndereco());

        return response;
    }
}
