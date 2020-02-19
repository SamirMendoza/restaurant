package com.adn.restaurant.infrastructure.adapter.repository.database.jpaentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.adn.restaurant.domain.model.Reservation;

@Entity (name = "reservations")
public class JpaReservation extends Reservation{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	
	@NotNull
	private Long idTable;
	
	@NotNull
	private double price;
	
	@NotNull
	private String name;
	
	public JpaReservation() {
	}
	

}
