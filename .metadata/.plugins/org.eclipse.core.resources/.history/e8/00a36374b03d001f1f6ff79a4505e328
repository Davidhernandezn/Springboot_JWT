package com.cursos.api.springsecuritycourse.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cursos.api.springsecuritycourse.persistence.entity.Product;

public interface ProductService {

	//DEVUELVE  UNA PAGUINACION DE PRODUCTOS Y RECIBE LOS PARAMETROS PARA CONFIGURAR LA PAGUINACION
	Page<Product> findAll(Pageable pageable);//FIRMA DE INTERFAZ NUMERO Y TAMAÑO
	
	//DEVUELBE OPTIONAL PARAMETRO ID
	Optional<Product>findOneById(Long productId);
}
