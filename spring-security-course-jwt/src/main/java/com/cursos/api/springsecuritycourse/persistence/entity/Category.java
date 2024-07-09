package com.cursos.api.springsecuritycourse.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public enum Category {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)//PARA NO GUARDAR NUMERACION
	private categoryStatus status;
	
	//numeracion estatica
	public static enum CategoryStatus{
		ENABLED, DISABLED //LLAVES
	}
	
	

}
