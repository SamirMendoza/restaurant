package com.adn.restaurant.application.querys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.restaurant.domain.model.Table;
import com.adn.restaurant.domain.ports.TableRepository;

@Service
public class TableQueryService {
	
	private TableRepository tableRepository;
	
	@Autowired
	public TableQueryService(TableRepository tableRepository) {
		this.tableRepository = tableRepository;
	}

	public List<Table> findAll(){
		return tableRepository.findAll();
	}

	public TableQueryService() {
	}
}
