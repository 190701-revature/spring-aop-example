package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
