package com.zavada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zavada.entity.CarEntity;
import com.zavada.repository.CarEntityRepository;
import com.zavada.service.CarEntityService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {
	
	@Autowired CarEntityService carEntityService;

	@GetMapping("/test")
	public String sayHello() {
		
		return "Hello World";
	}
	
	@GetMapping("/products")
	public List<CarEntity> getCarEntitys(){
		
		return carEntityService.findAllCarEntity();
	}
	
	@GetMapping("/buy")
	public ResponseEntity<?> buy(@RequestParam("carEntityId")String carEntityId){
		int cid = Integer.valueOf(carEntityId);
		CarEntity entity = carEntityService.findCarEntitybyid(cid);
		entity.setInStock(entity.getInStock() - 1);
		carEntityService.saveOrUpdate(entity);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
