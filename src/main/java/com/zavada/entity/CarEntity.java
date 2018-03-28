package com.zavada.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.zavada.entity.enumeration.BodyType;
import com.zavada.entity.enumeration.Color;
import com.zavada.entity.enumeration.FuelType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "carentity")
@NoArgsConstructor
@Getter @Setter
@AllArgsConstructor
public class CarEntity extends BaseEntity {
	private String make;
	private String model;
	
private int inStock;
	private Integer price;
}
