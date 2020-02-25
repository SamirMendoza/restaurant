package com.adn.restaurant.infrastructure.adapter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adn.restaurant.application.commands.ReservationCommandService;
import com.adn.restaurant.application.commands.dto.ReservationDeleteCommand;
import com.adn.restaurant.application.commands.dto.ReservationSaveCommand;


@CrossOrigin
@RestController("reservationCommandRestController")
@RequestMapping("restaurant/reservations")
public class ReservationCommandRestController {
	
	private ReservationCommandService reservationCommandService;

	public ReservationCommandRestController(ReservationCommandService reservationCommandService) {
		this.reservationCommandService = reservationCommandService;
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody ReservationSaveCommand reservationSaveCommand) {
		reservationCommandService.create(reservationSaveCommand);
	}
	
	@PutMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@RequestBody ReservationDeleteCommand reservationDeleteCommand) {
		reservationCommandService.delete(reservationDeleteCommand);
	}
	
}
