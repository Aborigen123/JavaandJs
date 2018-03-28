package com.zavada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zavada.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{

}
