package com.adn.restaurant.domain.ports;

import com.adn.restaurant.domain.model.Reservation;

public interface ReservationRepository {
	
	/**
	 * Permite agregar una reserva al repositorio
	 * @param reserva
	 */
	void save(Reservation reserva);
}
