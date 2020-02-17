package com.adn.restaurant.infrastructure.adapter.repository;

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
}
