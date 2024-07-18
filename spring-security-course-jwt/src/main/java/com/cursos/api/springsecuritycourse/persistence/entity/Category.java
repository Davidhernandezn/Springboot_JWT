package com.cursos.api.springsecuritycourse.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Enumerated(EnumType.STRING)//PARA NO GUARDAR NUMERACION
	private categoryStatus status;
	
	//numeracion estatica
	public static enum categoryStatus{
		ENABLED, DISABLED //LLAVES
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public categoryStatus getStatus() {
		return status;
	}

	public void setStatus(categoryStatus status) {
		this.status = status;
	}
	
	

}
