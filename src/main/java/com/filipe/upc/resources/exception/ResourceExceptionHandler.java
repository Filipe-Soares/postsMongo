package com.filipe.upc.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.filipe.upc.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(StandardError.builder()
						.timeStamp(System.currentTimeMillis())
						.status(HttpStatus.NOT_FOUND.value())
						.error("Não encontrado")
						.message(e.getMessage())
						.path(request.getRequestURI()).build());				
	}

}
