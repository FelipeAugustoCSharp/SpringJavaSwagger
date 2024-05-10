package com.projeto.faculdade.initial.service;

import com.projeto.faculdade.initial.entity.Pessoa;
import com.projeto.faculdade.initial.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> GetAll(){
        return pessoaRepository.findAll();
    }

    public Pessoa SavePessoa(Pessoa pessoa){
        System.out.println("pessoa entrou");
        return pessoaRepository.save(pessoa);
    }

    public Boolean deletePessoa(Integer id){
        Pessoa pessoa = pessoaRepository.findById(id).orElse(null);
        if (pessoa != null) {
            pessoaRepository.delete(pessoa);
            return true;
        }else{
            return false;
        }
    }
}
