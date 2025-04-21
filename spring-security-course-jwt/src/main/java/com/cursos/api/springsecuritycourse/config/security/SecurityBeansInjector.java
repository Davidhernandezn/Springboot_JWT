package com.cursos.api.springsecuritycourse.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

//PARA INYECTAR BEANS OCN LAS CLASE DEBES ANOTARLA CON CONFIGURATION
@Configuration
public class SecurityBeansInjector {
	
	@Autowired
	private AuthenticationConfiguration authenticationConfiguration; //DE SPRING sec
	
	//PARA INYECTAR CUALQUIER TIPO DE BEAN, A  CONTENEDOR DE DEPENCENCIAS
	@Bean
	public AuthenticationManager authenticationManager() throws Exception{
		
		//EL METODO GENERA UNA EXEPCION POR LO QUE SE LE AGREGA THROWS
	return	authenticationConfiguration.getAuthenticationManager(); //CREA AUTENTICACION (PROVIDE MANAGER), IMPLEMENTACION DEL AUTENTICATIO MANAGER
		
	}
	
	//PROVEEDOR DE AUTENTICACION
	@Bean
	public AuthenticationProvider autenticationProvider() {

		//DaoAuthenticationProvider CON TIENE EL MANEJO DEL LOGIN
		DaoAuthenticationProvider autenticationStrategy = new DaoAuthenticationProvider();
		autenticationStrategy.setPasswordEncoder(null);
		autenticationStrategy.setUserDetailsService(null);//estrategia de donde va a obtener al usuario en la base de datos
		return autenticationStrategy;
	}
	

}
