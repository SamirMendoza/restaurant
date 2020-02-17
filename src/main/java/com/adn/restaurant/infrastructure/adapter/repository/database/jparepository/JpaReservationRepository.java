package com.adn.restaurant.infrastructure.adapter.repository.database.jparepository;

import org.springframework.stereotype.Repository;

import com.adn.restaurant.infrastructure.adapter.repository.database.jpaentity.JpaReservation;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface JpaReservationRepository extends  JpaRepository<JpaReservation, Long>{
	
}
