package com.adn.restaurant.infrastructure.adapter.repository.database.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adn.restaurant.infrastructure.adapter.repository.database.jpaentity.JpaTable;

public interface JpaTableRepository extends  JpaRepository<JpaTable, Long>{

}
