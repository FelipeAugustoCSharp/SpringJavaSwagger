package com.projeto.faculdade.initial.repository;

import com.projeto.faculdade.initial.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}