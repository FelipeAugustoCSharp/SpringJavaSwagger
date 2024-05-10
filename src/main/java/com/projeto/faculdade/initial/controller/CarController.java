package com.projeto.faculdade.initial.controller;

import com.projeto.faculdade.initial.entity.Car;
import com.projeto.faculdade.initial.service.CarService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    @Operation(summary = "Lista carros disponíveis", description = "Retorna uma lista com todos os Carros disponíveis")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna um objeto contento uma lista de carros"),
        @ApiResponse(responseCode = "400", description = "Ocorreu um erro ao buscar carros")})
    public ResponseEntity<List<Car>> getCarros(){
        List<Car> carros  = carService.GetAll();
        if (!carros.isEmpty())
            return new ResponseEntity<>(carros, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna um carro", description = "Retorna um único carro com base em um Id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna um único carro"),
        @ApiResponse(responseCode = "400", description = "Ocorreu um erro ao buscar o carro")})
    public ResponseEntity<Car> getCarrosById(@PathVariable Integer id){
        Car carro = carService.getCarById(id);
        if (carro != null)
            return new ResponseEntity<>(carro, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @Operation(summary = "Cria um Carro", description = "Retorna o carro criado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna todos os dados do carro que foi adicionado"),
        @ApiResponse(responseCode = "400", description = "Ocorreu um erro ao salvar carro")})
    public ResponseEntity<Car> SaveCar(@RequestBody Car car){
        return new ResponseEntity<>(carService.SaveCar(car), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um carro", description = "Atualiza os dados de um carro com base em um Id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna o Carro com os dados atualizados"),
        @ApiResponse(responseCode = "400", description = "Ocorreu um erro ao atualizar Carro")})
    public ResponseEntity<Car> updateCar(@PathVariable Integer id, @RequestBody Car car){
        Car carroAtualizado = carService.AtualizarCarro(id, car);
        if (carroAtualizado != null)
            return new ResponseEntity<>(carroAtualizado, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um carro", description = "Retorna um Booleano contendo true ou false")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna true caso o carro tenha sido deletado"),
        @ApiResponse(responseCode = "400", description = "Ocorreu um erro ao deletar pessoa")})
    public ResponseEntity<Boolean> deleteCar(@PathVariable Integer id){
        if (carService.deleteCar(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }
}