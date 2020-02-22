package com.adn.restaurant.domain.ports;

import java.util.List;

import com.adn.restaurant.domain.model.Reservation;

public interface ReservationRepository {
	
	/**
	 * Permite agregar una reserva al repositorio
	 * @param reserva
	 */
	void save(Reservation reservation);
	
	/**
	 * Permite mostrar todas las reservas del repositorio
	 * @param 
	 * @return List<Reservation>
	 */
	List<Reservation> findAll();
	
	/**
	 * Permite eliminar una reserva del repositorio
	 * @param id
	 */
	void delete(Long id);
}
