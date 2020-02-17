package com.adn.restaurant.domain.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public interface AdditionalMethods {
	
	public static LocalDate toLocalDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return LocalDate.parse(format.format(date));
	}
}
