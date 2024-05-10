package com.projeto.faculdade.initial.entity;

import jakarta.persistence.*;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarro")
    private Integer id;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "ano_fabricacao")
    private Date ano_fabricacao;

    @Column(name = "desc")
    private String desc;

    @ManyToOne
    @JoinColumn(name = "idPessoa")
    @JsonBackReference
    private Pessoa pessoa;

    //GETTERS E SETTERS

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setAno_fabricacao(Date ano_fabricacao) {
        this.ano_fabricacao = ano_fabricacao;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    //getters

    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public Date getAno_fabricacao() {
        return ano_fabricacao;
    }

    public String getDesc() {
        return desc;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
}