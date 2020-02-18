package com.adn.restaurant.application.caseuse;

import com.adn.restaurant.domain.ports.ReservationRepository;
import com.adn.restaurant.domain.ports.TableRepository;

public class DeleteReservation {
	
	private ReservationRepository reservationRepository;
	private TableRepository tableRepository;
	
	public DeleteReservation(ReservationRepository reservationRepository, TableRepository tableRepository) {
		this.reservationRepository = reservationRepository;
		this.tableRepository = tableRepository;
	}
	
	public void delete(Long id) {
		reservationRepository.delete(id);
		tableRepository.save(tableRepository.findById(id));
	}
}
