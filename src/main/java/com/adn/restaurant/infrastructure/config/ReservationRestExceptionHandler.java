package com.adn.restaurant.infrastructure.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.adn.restaurant.domain.exception.ReservationException;

@ControllerAdvice
public class ReservationRestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ReservationException.class)
	public ResponseEntity<Object> reservationException(Exception ex, WebRequest request){
		 return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
