package com.zavada.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FuelType {

	DISEL("DISEL"),
	PETROL("PETROL"),
	GAS("GAS"),
	ELECTRO("ELECTRO"),
	PETROL_GAS("PETROL/GAS"),
	PETROL_ELECTRO("PERTOL/ELECTRO");
	
	private String type;
		
}
