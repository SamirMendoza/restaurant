package com.adn.restaurant.databuilder;

import com.adn.restaurant.domain.model.Table;

public class TableTestDataBuilder {
	
	private static final Long ID = 1L;
	private static final boolean AVAILABILITY = true;
	
	private Long id;
	private boolean availability;
	
	public TableTestDataBuilder() {
		this.id = ID;
		this.availability = AVAILABILITY;
	}
	
	public TableTestDataBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	
	public TableTestDataBuilder withAvailability(boolean availability) {
		this.availability = availability;
		return this;
	}
	
	public Table build() {
		return new Table(this.id, this.availability);
	}
}
