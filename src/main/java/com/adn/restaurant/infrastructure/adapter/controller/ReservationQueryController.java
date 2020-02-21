package com.adn.restaurant.infrastructure.adapter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.restaurant.application.querys.ReservationQueryService;
import com.adn.restaurant.domain.model.Reservation;


@RestController("reservationQueryRestController")
@RequestMapping("restaurant/reservations")
public class ReservationQueryController {
	
	private ReservationQueryService reservationQueryService;

	public ReservationQueryController(ReservationQueryService reservationQueryService) {
		this.reservationQueryService = reservationQueryService;
	}
	
	@GetMapping
	public List<Reservation> read() {
		return reservationQueryService.findAll();
	}
	
	@GetMapping("{id}")
	public Reservation read(@PathVariable Long id) {
		return reservationQueryService.findById(id);
	}
	
}
