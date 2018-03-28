package com.zavada.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zavada.entity.enumeration.BodyType;
import com.zavada.entity.enumeration.Color;
import com.zavada.entity.enumeration.FuelType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car", indexes = @Index(columnList = "make, model"))
@NoArgsConstructor
@Getter @Setter
public class Car extends BaseEntity {

	private String make;
	private String model;
	
	@Column(columnDefinition = "DECIMAL(7,2)")
	private BigDecimal price;
	
	@Column(name = "model_year")
	private String modelYear;
	
	@Enumerated(EnumType.STRING)
	private Color color;
	
	@Column(name = "fuel_type")
	@Enumerated(EnumType.STRING)
	private FuelType fuelType;
	
	@Column(name = "engine_capacity", columnDefinition = "DECIMAL(2,1)")
	private BigDecimal engineCapacity;
	
	@Column(name = "body_type")
	@Enumerated(EnumType.STRING)
	private BodyType bodyType;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {
			CascadeType.DETACH, 
			CascadeType.MERGE, 
			CascadeType.PERSIST, 
			CascadeType.REFRESH
	})
	
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@Column(name = "car_image")
	private String carImage;
}
