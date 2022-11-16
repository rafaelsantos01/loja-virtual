package com.dev.backend.modules.pessoa.repository;

import com.dev.backend.modules.pessoa.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
}
