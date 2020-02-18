package com.adn.restaurant.infrastructure.adapter.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adn.restaurant.domain.model.Table;
import com.adn.restaurant.domain.ports.TableRepository;
import com.adn.restaurant.infrastructure.adapter.repository.database.jparepository.JpaTableRepository;
import com.adn.restaurant.infrastructure.adapter.repository.database.mapper.JpaTableMapper;

@Repository
@Transactional
public class MysqlTableRepository implements TableRepository {
	
	JpaTableRepository jpaTableRepository;
	
	@Autowired
	public MysqlTableRepository(JpaTableRepository jpaTableRepository) {
		this.jpaTableRepository = jpaTableRepository;
	}

	@Override
	public void save(Table table) {
		table.setAvailability((table.isAvailability())?false:true);
		jpaTableRepository.save(JpaTableMapper.MAPPER.toJpaTable(table));		
	}

	@Override
	public Table findById(Long idTable) {
		return JpaTableMapper.MAPPER.toTable(jpaTableRepository.findById(idTable).orElse(null));
	}

	@Override
	public List<Table> findAll() {
		return JpaTableMapper.MAPPER.toTables(jpaTableRepository.findAll());
	}
}
