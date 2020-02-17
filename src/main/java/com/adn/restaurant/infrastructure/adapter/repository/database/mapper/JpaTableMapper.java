package com.adn.restaurant.infrastructure.adapter.repository.database.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.adn.restaurant.domain.model.Table;
import com.adn.restaurant.infrastructure.adapter.repository.database.jpaentity.JpaTable;


@Mapper
public interface JpaTableMapper {
	
	JpaTableMapper MAPPER = Mappers.getMapper(JpaTableMapper.class);

    Table toTable(JpaTable jpaTable);

    List<Table> toTables(List<JpaTable> jpaTables);

    JpaTable toJpaTable(Table table);

}
