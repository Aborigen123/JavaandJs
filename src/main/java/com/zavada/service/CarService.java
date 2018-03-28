package com.zavada.service;

import java.util.List;

import com.zavada.entity.Car;

public interface CarService {

	void saveCar(Car car);
	
	List<Car> findAllCars();
}
