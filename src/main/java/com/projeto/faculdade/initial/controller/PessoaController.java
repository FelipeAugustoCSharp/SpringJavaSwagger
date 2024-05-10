package com.projeto.faculdade.initial.controller;

import com.projeto.faculdade.initial.entity.Pessoa;
import com.projeto.faculdade.initial.service.PessoaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @GetMapping
    @Operation(summary = "Retorna Pessoas", description = "Retorna uma Lista de Pessoas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna um objeto contento uma lista de pessoas"),
        @ApiResponse(responseCode = "404", description = "Ocorreu um erro ao buscar pessoas")})
    public ResponseEntity<List<Pessoa>> getPessoas(){
        List<Pessoa> pessoas  = pessoaService.GetAll();
        if (!pessoas.isEmpty())
            return new ResponseEntity<>(pessoas, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Cria uma Pessoa", description = "Retorna uma Pessoas e os seus Carros")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna um objeto contento uma lista de pessoas e os seus respectivos carros"),
        @ApiResponse(responseCode = "400", description = "Ocorreu um erro ao salvar pessoa")})
    @PostMapping
    public ResponseEntity<Pessoa> SavePessoa(@RequestBody Pessoa pessoa){
        return new ResponseEntity<>(pessoaService.SavePessoa(pessoa), HttpStatus.CREATED);
    }
}
