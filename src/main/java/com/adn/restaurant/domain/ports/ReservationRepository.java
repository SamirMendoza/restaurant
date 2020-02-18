package com.adn.restaurant.domain.ports;

import java.util.List;

import com.adn.restaurant.domain.model.Reservation;

public interface ReservationRepository {
	
	/**
	 * Permite agregar una reserva al repositorio
	 * @param reserva
	 */
	void save(Reservation reserva);
	
	/**
	 * Permite mostrar todas las reservas del repositorio
	 * @param 
	 * @return List<Reservation>
	 */
	List<Reservation> findAll();
	
	/**
	 * Permite mostrar una reserva del repositorio
	 * @param id
	 * @return List<Reservation>
	 */
	Reservation findById(Long id);
	
	/**
	 * Permite eliminar una reserva del repositorio
	 * @param id
	 */
	void delete(Long id);
}
