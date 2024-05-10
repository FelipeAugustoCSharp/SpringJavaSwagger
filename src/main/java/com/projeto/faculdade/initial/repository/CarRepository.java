package com.projeto.faculdade.initial.repository;

import com.projeto.faculdade.initial.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}