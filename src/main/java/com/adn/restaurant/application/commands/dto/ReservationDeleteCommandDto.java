package com.adn.restaurant.application.commands.dto;

public class ReservationDeleteCommandDto {
	
	private long id;

	public ReservationDeleteCommandDto() {
	}

	public ReservationDeleteCommandDto(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
