package com.zavada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zavada.entity.Car;
import com.zavada.entity.CarEntity;

@Repository
public interface CarEntityRepository extends JpaRepository<CarEntity, Integer>{ 

}
