package com.adn.restaurant.infrastructure.adapter.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.adn.restaurant.domain.model.Table;
import com.adn.restaurant.domain.ports.TableRepository;
import com.adn.restaurant.infrastructure.adapter.repository.database.jparepository.JpaTableRepository;
import com.adn.restaurant.infrastructure.adapter.repository.database.mapper.JpaTableMapper;

@Repository
@Transactional
public class MysqlTableRepository implements TableRepository {
	
	JpaTableRepository jpaTableRepository;
	JpaTableMapper jpaTableMapper;
	
	public MysqlTableRepository() {
	}

	public MysqlTableRepository(JpaTableRepository jpaTableRepository) {
		this.jpaTableRepository = jpaTableRepository;
	}

	public MysqlTableRepository(JpaTableRepository jpaTableRepository, JpaTableMapper jpaTableMapper) {
		this.jpaTableRepository = jpaTableRepository;
		this.jpaTableMapper = jpaTableMapper;
	}

	@Override
	public void save(Table table) {
		table.setAvailability((table.isAvailability())?false:true);
		jpaTableRepository.save(jpaTableMapper.toJpaTable(table));		
	}

	@Override
	public Table findById(Long idTable) {
		return jpaTableMapper.toTable(jpaTableRepository.findById(idTable).orElse(null));
	}

	@Override
	public List<Table> findAll() {
		return jpaTableMapper.toTables(jpaTableRepository.findAll());
	}
}
