package com.adn.restaurant.application.commands.dto;

import java.time.LocalDate;

public class ReservationSaveCommand {
	
	private Long idTable;
	private double price;
	private String name;
	private LocalDate dateReservation;
	private LocalDate dateRequest;
	
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
	public LocalDate getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}
	public LocalDate getDateRequest() {
		return dateRequest;
	}
	public void setDateRequest(LocalDate dateRequest) {
		this.dateRequest = dateRequest;
	}
}
