package com.adn.restaurant.infrastructure.adapter.repository.database.mapper;


import com.adn.restaurant.domain.model.Table;
import com.adn.restaurant.infrastructure.adapter.repository.database.jpaentity.JpaTable;


public interface JpaTableMapper {

	public static Table toTable(JpaTable jpaTable) {
		Table table = new Table();
		
		table.setId(jpaTable.getId());
		table.setAvailability(jpaTable.isAvailability());
		
		return table;
	}

	public static JpaTable toJpaTable(Table table) {
		JpaTable jpaTable = new JpaTable();
		
		jpaTable.setId(table.getId());
		jpaTable.setAvailability(table.isAvailability());
		
		return jpaTable;
	}

}
