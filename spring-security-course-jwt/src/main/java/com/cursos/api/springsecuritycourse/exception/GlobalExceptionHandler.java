package com.cursos.api.springsecuritycourse.exception;

import java.time.LocalDateTime;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cursos.api.springsecuritycourse.dto.ApiError;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	//RestController - CONTROLA PETICIONES HTTP
	//@RestControllerAdvice MAPEA Y CONTROLA ERRORES EXEPCIONES
	
	//NOTACION PARA MANEJAR ERRORES, podemos pasar una excepcion o un arreglo
	//podemos leer la documentacion de esta anotacion para ver lo que puede recibir en los parametros
	
	/**ERROR GENERICO*/
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handlerGenericException(HttpServletRequest request, Exception exception){
		
		ApiError apiError = new ApiError();
		apiError.setBackendMessage(exception.getLocalizedMessage()); //INFORMATIVO QUE ERROR OCURRIO
		apiError.setUrl(request.getRequestURL().toString()); //to string porque devuelve un objeto
		apiError.setMethod(request.getMethod());
		apiError.setMessage("Error interno en el servidor, vuelva a intentarlo");//
		apiError.setTimestamp(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
	}
	
	
	
	/**ERROR POR ARGUMENTOS NO VALIDOS*/
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerMethodArgumentNotValidException(HttpServletRequest request, 
			MethodArgumentNotValidException exception){
		
		ApiError apiError = new ApiError();
		apiError.setBackendMessage(exception.getLocalizedMessage()); //INFORMATIVO QUE ERROR OCURRIO
		apiError.setUrl(request.getRequestURL().toString()); //to string porque devuelve un objeto
		apiError.setMethod(request.getMethod());
		apiError.setMessage("Error en peticiòn enviada");//
		apiError.setTimestamp(LocalDateTime.now());
		//MENSAJE ESPECIFICO
		//INVESTIGAR
		System.out.println(exception.getAllErrors().stream().map(each -> each.getDefaultMessage())
				.collect(Collectors.toList())
				);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
		//12.20
	}
}
