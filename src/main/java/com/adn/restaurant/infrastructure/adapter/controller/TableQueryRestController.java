package com.adn.restaurant.infrastructure.adapter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adn.restaurant.application.querys.TableQueryService;
import com.adn.restaurant.domain.model.Table;

@RestController("tableQueryRestController")
@RequestMapping("restaurant")
public class TableQueryRestController {
	
	private TableQueryService tableQueryService;
	
	public TableQueryRestController(TableQueryService tableQueryService) {
		this.tableQueryService = tableQueryService;
	}

	@GetMapping
	public List<Table> read() {
		return tableQueryService.findAll();
	}
	
}
