//package com.adn.restaurant.databuilder;
//
//import com.adn.restaurant.application.command.ReservationCommand;
//
//public class ReservationCommandTestDataBuilder {
//	
//	private static final Long ID_TABLE = 1L;
//	private static final double PRICE = 10000;
//	private static final String NAME = "Samir";
//	
//	private Long idTable;
//	private double price;
//	private String name;
//	
//	public ReservationCommandTestDataBuilder() {
//		this.idTable = ID_TABLE;
//		this.price = PRICE;
//		this.name = NAME;
//	}
//	
//	public ReservationCommandTestDataBuilder withIdTable(Long idTable) {
//		this.idTable = idTable;
//		return this;
//	}
//	
//	public ReservationCommandTestDataBuilder withPrice(double price) {
//		this.price = price;
//		return this;
//	}
//	
//	public ReservationCommandTestDataBuilder withName(String name) {
//		this.name = name;
//		return this;
//	}
//	
//	public ReservationCommand build(){
//		ReservationCommand reservationCommand = new ReservationCommand();
//		reservationCommand.setIdTable(this.idTable);
//		reservationCommand.setPrice(this.price);
//		reservationCommand.setName(this.name);
//		return reservationCommand;
//	}
//}
