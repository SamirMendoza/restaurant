package com.adn.restaurant.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.adn.restaurant.application.querys.TableQueryService;
import com.adn.restaurant.databuilder.TableTestDataBuilder;
import com.adn.restaurant.domain.model.Table;
import com.adn.restaurant.domain.ports.TableRepository;

public class TableQueryServiceTest {
	
	private TableQueryService tableQueryService;
	
	@Mock
	private TableRepository tableRepository;
	
	@BeforeEach
	public void setup() {
        MockitoAnnotations.initMocks(this);
        this.tableQueryService = new TableQueryService(tableRepository);
	}
	
	@Test
	public void findAllTest() {
		//arrange
		List<Table> tables= new ArrayList<>();
		tables.add(new TableTestDataBuilder().withId(3L).build());
		tables.add(new TableTestDataBuilder().withId(6L).build());
		when(this.tableRepository.findAll()).thenReturn(tables);
		//act
		List<Table> tablesResponse = this.tableQueryService.findAll();
		
		//assert

		Assertions.assertEquals(tables.size(), tablesResponse.size());
		Assertions.assertEquals(3L, tablesResponse.get(0).getId().longValue());
		Assertions.assertEquals(6L, tablesResponse.get(1).getId().longValue());
		
	}
}
