package com.brq.handlers;

import java.time.LocalDateTime;
//import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.brq.exceptions.FieldMessageList;
import com.brq.exceptions.ObjetoNaoEncontradoException;
import com.brq.exceptions.StandardError;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	// Manipula para uma exceção específica(quando um argumento não for valido ele passa por esse metodo)
	@ExceptionHandler (MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validador(MethodArgumentNotValidException e, HttpServletRequest request) {
		
//		StandardError error = new StandardError(System.currentTimeMillis(), 404, "Objeto não encontrado", e.getMessage(), request.getRequestURI());
		FieldMessageList error = new FieldMessageList(LocalDateTime.now(), 
				HttpStatus.UNPROCESSABLE_ENTITY.value(), 
				"Exceção", 
				"Erro ao validar os dados", 
				request.getRequestURI());
		
		for (FieldError fe: e.getBindingResult().getFieldErrors()) {
			error.addError(fe.getField(), fe.getDefaultMessage());	
			
		}
		
		
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).body(error);
	}
	
	
	@ExceptionHandler (ObjetoNaoEncontradoException.class)
	public ResponseEntity<StandardError> objetoNaoEncontrado (ObjetoNaoEncontradoException e, HttpServletRequest request) {
		StandardError error = new StandardError(
				LocalDateTime.now(), 
				HttpStatus.NOT_FOUND.value(), 
				"Objeto não encontrado", 
				e.getMessage(), 
				request.getRequestURI());
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
	
	}
	
	
	
	
	
	
	

}
