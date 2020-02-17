package com.adn.restaurant.domain.model;

import java.util.Date;

public class Reservation {
	
	private Long code;
	private Long idTable;
	private Date dateRequest;
	private Date dateReservation;
	private double price;
	private String name;
	
	public Reservation(Long idTable, Date dateRequest, Date dateReservation, double price, String name) {
		this.idTable = idTable;
		this.dateRequest = dateRequest;
		this.dateReservation = dateReservation;
		this.price = price;
		this.name = name;
	}
	
	public Reservation() {
	}

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
	
}
