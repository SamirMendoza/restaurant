package com.adn.restaurant.databuilder;

import java.time.LocalDate;

import com.adn.restaurant.application.commands.dto.ReservationSaveCommand;

public class ReservationSaveCommandTestDataBuilder {
	
	private static final Long ID_TABLE = 3L;
	private static final double PRICE = 1000;
	private static final String NAME = "raul";
	private static final LocalDate DATE_RESERVATION = LocalDate.of(2020, 2, 21);
	private static final LocalDate DATE_REQUEST = LocalDate.of(2020, 2, 17);
	
	private Long idTable;
	private double price;
	private String name;
	private LocalDate dateReservation;
	private LocalDate dateRequest;
	
	
	public ReservationSaveCommandTestDataBuilder() {
		this.idTable = ID_TABLE;
		this.price = PRICE;
		this.name = NAME;
		this.dateReservation = DATE_RESERVATION;
		this.dateRequest = DATE_REQUEST;
	}
	
	public ReservationSaveCommandTestDataBuilder withIdTable(Long idTable) {
	this.idTable = idTable;
	return this;
	}
	
	public ReservationSaveCommandTestDataBuilder withPrice(double price) {
		this.price = price;
		return this;
	}
	
	public ReservationSaveCommandTestDataBuilder withName(String name) {
		this.name = name;
		return this;
	}
	
	public ReservationSaveCommandTestDataBuilder withDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
		return this;
	}
	
	public ReservationSaveCommandTestDataBuilder withDateReques(LocalDate dateRequest) {
		this.dateRequest = dateRequest;
		return this;
	}
	
	public ReservationSaveCommand build(){
	ReservationSaveCommand reservationSaveCommand = new ReservationSaveCommand();
	reservationSaveCommand.setIdTable(this.idTable);
	reservationSaveCommand.setPrice(this.price);
	reservationSaveCommand.setName(this.name);
	reservationSaveCommand.setDateReservation(this.dateReservation);
	reservationSaveCommand.setDateRequest(this.dateRequest);
	return reservationSaveCommand;
}
	
}
