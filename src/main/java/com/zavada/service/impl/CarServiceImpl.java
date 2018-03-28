package com.zavada.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zavada.entity.Car;
import com.zavada.repository.CarRepository;
import com.zavada.service.CarService;

@Service
public class CarServiceImpl implements CarService{

	@Autowired CarRepository carRepository;
	
	@Override
	public void saveCar(Car car) {
		carRepository.save(car);
	}

	@Override
	public List<Car> findAllCars() {
		return carRepository.findAll();
	}

	
	
}
