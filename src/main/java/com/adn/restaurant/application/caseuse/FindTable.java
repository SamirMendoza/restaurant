package com.adn.restaurant.application.caseuse;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adn.restaurant.domain.model.Table;
import com.adn.restaurant.domain.ports.TableRepository;

@Service
public class FindTable {
	
	private TableRepository tableRepository;
	
	public FindTable(TableRepository tableRepository) {
		this.tableRepository = tableRepository;
	}

	public List<Table> findAll(){
		return tableRepository.findAll();
	}
}
