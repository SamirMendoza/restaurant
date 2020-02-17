package com.adn.restaurant.infrastructure.adapter.repository.database.jpaentity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.adn.restaurant.domain.model.Reservation;

@Entity (name = "reservation")
public class JpaReservation extends Reservation{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	@NotNull
	private Long idTable;
	@NotNull
	private Date dateRequest;
	@NotNull
	private Date dateReservation;
	@NotNull
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
	public Date getDateRequest() {
		return dateRequest;
	}
	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
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
