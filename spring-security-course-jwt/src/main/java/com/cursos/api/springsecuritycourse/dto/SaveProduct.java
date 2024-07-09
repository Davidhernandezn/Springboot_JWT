package com.cursos.api.springsecuritycourse.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class SaveProduct implements Serializable{
	
	@NotBlank //EN CONTROLADOR VALIDA QUE NO ESTE VACIO
	private String name;
	
	@DecimalMin(value="0.01")//ACEPTA EL VALOR MINIMO
	private BigDecimal price;
	
	@Min(value = 1)//MAYOR O IGUAL A 1
	private Long categoryId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
