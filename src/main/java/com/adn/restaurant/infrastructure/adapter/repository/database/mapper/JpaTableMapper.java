package com.adn.restaurant.infrastructure.adapter.repository.database.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.adn.restaurant.domain.model.Table;
import com.adn.restaurant.infrastructure.adapter.repository.database.jpaentity.JpaTable;


@Mapper(componentModel = "spring")
public interface JpaTableMapper {

    Table toTable(JpaTable jpaTable);

    List<Table> toTables(List<JpaTable> jpaTables);

    JpaTable toJpaTable(Table table);

}
