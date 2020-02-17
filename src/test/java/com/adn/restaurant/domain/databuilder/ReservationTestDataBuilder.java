package com.adn.restaurant.domain.databuilder;

import com.adn.restaurant.domain.model.Reservation;

public class ReservationTestDataBuilder {
	
	private static final Long CODE = 1L;
	private static final Long ID_TABLE = 1L;
	private static final double PRICE = 10000;
	private static final String NAME = "Samir";
	
	private Long code;
	private Long idTable;
	private double price;
	private String name;
	
	public ReservationTestDataBuilder() {
		this.code = CODE;
		this.idTable = ID_TABLE;
		this.price = PRICE;
		this.name = NAME;
	}
	
	public ReservationTestDataBuilder withCode(Long code) {
		this.code = code;
		return this;
	}
	
	public ReservationTestDataBuilder withIdTable(Long idTable) {
		this.idTable = idTable;
		return this;
	}
	
	public ReservationTestDataBuilder withPrice(double price) {
		this.price = price;
		return this;
	}
	
	public ReservationTestDataBuilder withName(String name) {
		this.name = name;
		return this;
	}
	
	public Reservation build(){
		Reservation reservation = new Reservation(this.idTable, this.price, this.name);
		reservation.setCode(this.code);
		return reservation;
	}
}
