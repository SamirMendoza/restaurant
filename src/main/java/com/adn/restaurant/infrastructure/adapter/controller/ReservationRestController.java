package com.adn.restaurant.infrastructure.adapter.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.adn.restaurant.application.caseuse.CreateReservation;
import com.adn.restaurant.application.caseuse.DeleteReservation;
import com.adn.restaurant.application.caseuse.FindReservation;
import com.adn.restaurant.application.command.ReservationCommand;
import com.adn.restaurant.domain.model.Reservation;

@Controller
@RequestMapping(path = "/restaurant")
public class ReservationRestController {
	
	private CreateReservation createReservation;
	private FindReservation findReservation;
	private DeleteReservation deleteReservation;
	
	public ReservationRestController(CreateReservation createReservation, FindReservation findReservation,
			DeleteReservation deleteReservation) {
		this.createReservation = createReservation;
		this.findReservation = findReservation;
		this.deleteReservation = deleteReservation;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation create(@RequestBody ReservationCommand reservationCommand, LocalDate dateReservation){ 
		return createReservation.create(reservationCommand, dateReservation);
	}
	
	@GetMapping
	public List<Reservation> read() {
		return findReservation.findAll();
	}
	
	@GetMapping("{id}")
	public Reservation read(@PathVariable Long id) {
		return findReservation.findById(id);
	}
	
	@DeleteMapping("{id}")
	public Reservation delete(@PathVariable Long id) {
		return deleteReservation.delete(id);
	}
	
	
}
	