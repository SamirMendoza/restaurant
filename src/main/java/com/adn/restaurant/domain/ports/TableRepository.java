package com.adn.restaurant.domain.ports;

import java.util.List;

import com.adn.restaurant.domain.model.Table;

public interface TableRepository {
	
	/**
	 * Permite agregar o actualizar una mesa al repositorio
	 * @param table
	 */
	void save(Table table);	
	
	/**
	 * Permite traer una mesa del repositorio
	 * @param idTable
	 */
	Table findById(Long idTable);

	/**
	 * Permite traer todas las mesas del repositorio
	 */
	List<Table> findAll();
}
