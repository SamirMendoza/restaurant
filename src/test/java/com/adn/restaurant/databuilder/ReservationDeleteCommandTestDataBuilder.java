package com.adn.restaurant.databuilder;

import com.adn.restaurant.application.commands.dto.ReservationDeleteCommand;

public class ReservationDeleteCommandTestDataBuilder {
	
	private static final long ID = 3;
	
	private long id;

	public ReservationDeleteCommandTestDataBuilder() {
		this.id = ID;
	}
	
	public ReservationDeleteCommandTestDataBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	
	public ReservationDeleteCommand build() {
		ReservationDeleteCommand reservationDeleteCommand = new ReservationDeleteCommand();
		reservationDeleteCommand.setId(this.id);
		
		return reservationDeleteCommand;
	}
	
	
}
