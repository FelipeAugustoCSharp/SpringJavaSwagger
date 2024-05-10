package com.projeto.faculdade.initial.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPessoa")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private Date data_nascimento;

    @OneToMany(mappedBy = "pessoa")
    @JsonManagedReference
    private Set<Car> carros;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public Set<Car> getCarros() {
        return carros;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setCarros(Set<Car> carros) {
        this.carros = carros;
    }
}

