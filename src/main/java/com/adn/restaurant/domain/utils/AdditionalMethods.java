package com.adn.restaurant.domain.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public interface AdditionalMethods {
	
	public static LocalDate toLocalDate(Date date) {
		LocalDate dateInLocalDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return dateInLocalDate;
	}
}
