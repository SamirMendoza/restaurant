package com.adn.restaurant.caseuse;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.adn.restaurant.application.caseuse.FindTable;
import com.adn.restaurant.databuilder.TableTestDataBuilder;
import com.adn.restaurant.domain.model.Table;
import com.adn.restaurant.domain.ports.TableRepository;

public class FindTableTest {
	
	private FindTable findtable;
	@Mock
	private TableRepository tableRepository;
	
	@BeforeEach
	public void setup() {
        MockitoAnnotations.initMocks(this);
        this.findtable = new FindTable(tableRepository);
	}
	
	@Test
	public void findAllTest() {
		//arrange
		List<Table> tables= new ArrayList<>();
		tables.add(new TableTestDataBuilder().withId(3L).build());
		tables.add(new TableTestDataBuilder().withId(6L).build());
		when(this.tableRepository.findAll()).thenReturn(tables);
		//act
		List<Table> tablesResponse = this.findtable.findAll();
		
		//assert

		Assert.assertEquals(tables.size(), tablesResponse.size());
		Assert.assertEquals(3L, tables.get(0).getId().longValue());
		Assert.assertEquals(6L, tables.get(1).getId().longValue());
		
	}
	
}
