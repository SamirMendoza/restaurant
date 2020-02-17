package com.adn.restaurant.infrastructure.adapter.controller;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.adn.restaurant.application.caseuse.CreateReservation;
import com.adn.restaurant.application.command.ReservationCommand;
import com.adn.restaurant.domain.model.Reservation;

@Controller
@RequestMapping(path = "/restaurante")
public class ReservationRestController {
	
	private CreateReservation createReservation;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation createR(@RequestBody ReservationCommand reservationCommand){ 
		return createReservation.create(reservationCommand);
	}
}
	