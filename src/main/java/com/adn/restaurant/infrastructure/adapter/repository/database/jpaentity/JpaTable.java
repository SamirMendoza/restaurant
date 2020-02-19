package com.adn.restaurant.infrastructure.adapter.repository.database.jpaentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.adn.restaurant.domain.model.Table;


@Entity (name = "tables")

public class JpaTable extends Table{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private boolean availability;
	
	public JpaTable() {
	}
	
}
