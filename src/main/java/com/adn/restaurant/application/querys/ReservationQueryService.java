package com.adn.restaurant.application.querys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.restaurant.domain.model.Reservation;
import com.adn.restaurant.domain.ports.ReservationRepository;

@Service
public class ReservationQueryService {
	
	private ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationQueryService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	public List<Reservation> findAll(){
		return reservationRepository.findAll();
	}

	public Reservation findById(Long id) {
		return reservationRepository.findById(id);
	}

	public ReservationQueryService() {
	}
	
}
