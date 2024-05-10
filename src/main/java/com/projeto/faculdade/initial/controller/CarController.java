package com.projeto.faculdade.initial.controller;

import com.projeto.faculdade.initial.entity.Car;
import com.projeto.faculdade.initial.service.CarService;
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
    public ResponseEntity<List<Car>> getCarros(){
        List<Car> carros  = carService.GetAll();
        if (!carros.isEmpty())
            return new ResponseEntity<>(carros, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarrosById(@PathVariable Integer id){
        Car carro = carService.getCarById(id);
        if (carro != null)
            return new ResponseEntity<>(carro, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Car> SaveCar(@RequestBody Car car){
        return new ResponseEntity<>(carService.SaveCar(car), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Integer id, @RequestBody Car car){
        Car carroAtualizado = carService.AtualizarCarro(id, car);
        if (carroAtualizado != null)
            return new ResponseEntity<>(carroAtualizado, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCar(@PathVariable Integer id){
        if (carService.deleteCar(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }
}