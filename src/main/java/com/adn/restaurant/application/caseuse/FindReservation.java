package com.adn.restaurant.application.caseuse;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adn.restaurant.domain.model.Reservation;
import com.adn.restaurant.domain.ports.ReservationRepository;

@Service
public class FindReservation {
	
	private ReservationRepository reservationRepository;
	
	public FindReservation(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}
	
	public List<Reservation> findAll(){
		return reservationRepository.findAll();
	}

	public Reservation findById(Long id) {
		return reservationRepository.findById(id);
	}
	
	
}
