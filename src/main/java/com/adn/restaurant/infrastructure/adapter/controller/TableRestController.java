package com.adn.restaurant.infrastructure.adapter.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adn.restaurant.application.caseuse.FindTable;
import com.adn.restaurant.domain.model.Table;


@Controller
@RequestMapping(path = "/tables")
public class TableRestController {
	
	private FindTable findTable;
	
	public TableRestController(FindTable findTable) {
		this.findTable = findTable;
	}

	@GetMapping
	public List<Table> read() {
		return findTable.findAll();
	}
}
