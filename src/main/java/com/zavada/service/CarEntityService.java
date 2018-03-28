package com.zavada.service;

import java.util.List;

import com.zavada.entity.CarEntity;

public interface CarEntityService {
	List<CarEntity> findAllCarEntity();
	
	CarEntity findCarEntitybyid(int id);
	
	void saveOrUpdate(CarEntity entity);

}
