package com.cursos.api.springsecuritycourse.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

public class SaveCategory implements Serializable{
	
	@NotBlank //CUANDO ESTE EN CONTROLADOR VALIDA QUE NO ESTE VACIO
	private String name;

}
