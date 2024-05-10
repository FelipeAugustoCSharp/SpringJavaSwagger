package com.projeto.faculdade.initial.service;

import com.projeto.faculdade.initial.entity.Car;
import com.projeto.faculdade.initial.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public List<Car> GetAll(){
        return carRepository.findAll();
    }

    public Car getCarById(Integer id){
        return carRepository.findById(id).orElse(null);
    }

    public Car SaveCar(Car carro){
        return carRepository.save(carro);
    }

    public Car AtualizarCarro(Integer id, Car carro){
        Car carroAtualizado = carRepository.findById(id).orElse(null);

        if (carroAtualizado != null){
            carroAtualizado.setModelo(carro.getModelo());
            carroAtualizado.setAno_fabricacao(carro.getAno_fabricacao());
            carroAtualizado.setDesc(carro.getDesc());
            
            return carRepository.save(carroAtualizado);
        }else{
            return null;
        }
    }

    public Boolean deleteCar(Integer id){
        Car carro = carRepository.findById(id).orElse(null);
        if (carro != null) {
            carRepository.delete(carro);
            return true;
        }else{
            return false;
        }
    }
}