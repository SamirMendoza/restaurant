package com.adn.restaurant.domain.model;

public class Table {
	
	private Long id;
	private boolean availability;
	
	public Table(Long id, boolean availability) {
		this.id = id;
		this.availability = availability;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Table() {
	}
	
	
}
