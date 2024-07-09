package com.cursos.api.springsecuritycourse.persistence.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	private ProductStatus status;
	
	//ESTO SE GUARDA EN BD, PERO LO NECESITAMOS EN STRING, ES DECIR SE GUARDARÁ LO QUE SIGNIFICA
	//NUMERACION STATICA, ACCEDIDA DESDE LA CLASE PRINCIPAL DEL PRODUCTO
	public static enum ProductStatus{
		//ENUMERACIONES TIENEN UN VALOR ORDINAL 0,1
		ENABLED, DISABLED;
	}
	
	//RELACION CON CATEGORY, agregar geter ans setter
	//SE CREA UN ATRIBUTO CATEGORY ID, CON LLAVE FORANEA CON CATEGORIA
	@ManyToOne //MUCHOS PRODUCTOS ESTARAN ASOCIADOS A UNA CATEGORIA
	@JoinColumn(name="category_id")//JPA- COMO DEBE CREAR EL CAMPO CAGTEGORY EN TABLA PRODUCTO
	private Category category;
	

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}

	//RELACION CON CATEGORIA
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}
