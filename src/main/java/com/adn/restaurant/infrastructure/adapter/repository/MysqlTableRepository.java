 package com.adn.restaurant.infrastructure.adapter.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.adn.restaurant.domain.model.Table;
import com.adn.restaurant.domain.ports.TableRepository;
import com.adn.restaurant.infrastructure.adapter.repository.database.jpaentity.JpaTable;
import com.adn.restaurant.infrastructure.adapter.repository.database.jparepository.JpaTableRepository;
import com.adn.restaurant.infrastructure.adapter.repository.database.mapper.JpaTableMapper;

@Component
public class MysqlTableRepository implements TableRepository {
	
	private JpaTableRepository jpaTableRepository;
	
	public MysqlTableRepository(JpaTableRepository jpaTableRepository) {
		this.jpaTableRepository = jpaTableRepository;
	}

	@Override
	public void save(Table table) {
		table.setAvailability((table.isAvailability())?false:true);
		jpaTableRepository.save(JpaTableMapper.toJpaTable(table));		
	}

	@Override
	public Table findById(Long idTable) {
		return JpaTableMapper.toTable(jpaTableRepository.findById(idTable).orElse(null));
	}

	@Override
	public List<Table> findAll() {
		
		List<Table> tables = new ArrayList<>();
		List<JpaTable> jpaTables = jpaTableRepository.findAll();
		jpaTables.forEach(value -> tables.add(JpaTableMapper.toTable(value)));
		return tables;
	}
}
