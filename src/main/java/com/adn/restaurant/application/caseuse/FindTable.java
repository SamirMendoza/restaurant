package com.adn.restaurant.application.caseuse;

import java.util.List;

import com.adn.restaurant.domain.model.Reservation;
import com.adn.restaurant.domain.model.Table;
import com.adn.restaurant.domain.ports.TableRepository;

public class FindTable {
	
	private TableRepository tableRepository;
	
	public List<Table> findAll(){
		return tableRepository.findAll();
	}
}
