package com.zavada.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zavada.entity.CarEntity;
import com.zavada.repository.CarEntityRepository;
import com.zavada.service.CarEntityService;
@Service
public class CarEntityServiceImpl implements CarEntityService {

	@Autowired private CarEntityRepository carEntityRepository;
	
	@Override
	public List<CarEntity> findAllCarEntity() {
		
		return carEntityRepository.findAll();
	}

	@Override
	public CarEntity findCarEntitybyid(int id) {
		
		return carEntityRepository.findOne(id);
	}

	@Override
	public void saveOrUpdate(CarEntity entity) {
		carEntityRepository.save(entity);
		
	}

}
