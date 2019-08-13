package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Car;
import com.revature.repositories.CarRepository;

@Service
public class CarService {

	CarRepository carRepository;
	
	@Autowired
	public CarService(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}

	public Car getById(int id) {
		return carRepository.findById(id)
			.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

	public Car save(Car car) {
		return carRepository.save(car);
	}

}
