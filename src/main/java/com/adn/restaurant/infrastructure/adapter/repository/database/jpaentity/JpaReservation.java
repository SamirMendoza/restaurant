package com.adn.restaurant.infrastructure.adapter.repository.database.jpaentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.adn.restaurant.domain.model.Reservation;

@Entity (name = "reservations")
public class JpaReservation extends Reservation{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private Long idTable;
	private double price;
	private String name;
	
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public Long getIdTable() {
		return idTable;
	}
	public void setIdTable(Long idTable) {
		this.idTable = idTable;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public JpaReservation() {
	}
	

}
