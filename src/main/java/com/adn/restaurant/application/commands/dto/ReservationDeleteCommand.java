package com.adn.restaurant.application.commands.dto;

public class ReservationDeleteCommand {
	
	private long id;

	public ReservationDeleteCommand() {
	}

	public ReservationDeleteCommand(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
