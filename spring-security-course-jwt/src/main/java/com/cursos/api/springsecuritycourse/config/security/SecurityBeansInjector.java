package com.cursos.api.springsecuritycourse.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cursos.api.springsecuritycourse.exception.ObjectNotFoundException;
import com.cursos.api.springsecuritycourse.persistence.repository.UserRepository;

//PARA INYECTAR BEANS OCN LAS CLASE DEBES ANOTARLA CON CONFIGURATION
@Configuration
public class SecurityBeansInjector {
	
	@Autowired
	private AuthenticationConfiguration authenticationConfiguration; //DE SPRING sec
	
	@Autowired
	private UserRepository userRepository;
	
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
		autenticationStrategy.setPasswordEncoder(passwordEncoder());
		autenticationStrategy.setUserDetailsService(userDetailsService());//estrategia de donde va a obtener al usuario en la base de datos (bd)
		return autenticationStrategy;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
//		return new UserDetailsService() {
//			/*AL AGREGARLO VA A SOBRESCRIBIR EL UNICO METODO QUE TIENE ES MEJOR AGREGARLO EN LAMBDA*/
//			@Override
//			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
//		
		/*Metodo que recibe un string username -> metodo a crear
		 * */
		return (username) -> {
			return userRepository.findByUsername(username)//devuelve optional
					.orElseThrow(() -> new ObjectNotFoundException("User not found with username " + username));
		};
	
	}
}
