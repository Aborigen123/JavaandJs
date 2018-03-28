package com.zavada.mapper;

import com.zavada.domain.CreateAdvRequest;
import com.zavada.entity.Car;

public interface CarMapper {

	public static Car advRequestToCar(CreateAdvRequest advRequest) {
		Car car = new Car();
		car.setMake(advRequest.getMake());
		car.setModel(advRequest.getModel());
		car.setPrice(advRequest.getPrice());
		car.setModelYear(advRequest.getModelYear());
		car.setColor(advRequest.getColor());
		car.setFuelType(advRequest.getFuelType());
		car.setEngineCapacity(advRequest.getEngineCapacity());
		car.setBodyType(advRequest.getBodyType());
		car.setUser(advRequest.getEntity());
		car.setCarImage(advRequest.getCarImage().getOriginalFilename());
		return car;
	}
}
