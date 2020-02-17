package com.adn.restaurant.domain.ports;

import com.adn.restaurant.domain.model.Table;

public interface TableRepository {
	
	/**
	 * Permite agregar una mesa al repositorio
	 * @param reserva
	 */
	void save(Table table);	
	
	/**
	 * Permite traer una mesa del repositorio
	 * @param reserva
	 */
	Table findById(Long idTable);
}
