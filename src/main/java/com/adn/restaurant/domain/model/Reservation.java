package com.adn.restaurant.domain.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

import com.adn.restaurant.domain.exception.ReservationException;

public class Reservation {
	
	private Long code;
	private Long idTable;
	private double price;
	private String name;
	
	public Reservation(Long idTable, double price, String name) {	
		this.idTable = idTable;
		this.price = price;
		this.name = name;
		}
	
	public void generateReservation(LocalDate dateRequest, LocalDate dateReservation) throws ReservationException{
		if (validatePrimeIdTable(dateRequest, dateReservation)) {
			throw new ReservationException("no puede reservar con menos de tres dias de antelacion");
		}
		
		if (validateEvenIdTable(dateReservation)) {
			giveDiscount();
		}
		
		if (validateUnevenIdTable(dateReservation)) {
			throw new ReservationException("no puede reservar los fines de semana");		}
	}
	
	public boolean validatePrimeIdTable(LocalDate dateRequest, LocalDate dateReservation) {
		return (validatePrimeNumber() && !validateDaysBetweenDates(dateRequest, dateReservation));
	}
	
	public boolean validateEvenIdTable(LocalDate dateReservation) {
		return (isEven() && validateNoWeekend(dateReservation));
	}
	
	public boolean validateUnevenIdTable(LocalDate dateReservation) {
		return (!isEven() && !validateNoWeekend(dateReservation));
	}
	
	public boolean validateNoWeekend(LocalDate dateReservation) {
		return (dateReservation.getDayOfWeek() != DayOfWeek.SATURDAY && dateReservation.getDayOfWeek() != DayOfWeek.SUNDAY);
	}
	
	public boolean validateDaysBetweenDates(LocalDate dateRequest, LocalDate dateReservation) {
		if (dateRequest.isEqual(dateReservation))
			return false;
		
		dateRequest = dateRequest.plusDays(1);
		
		return (!dateRequest.isEqual(dateReservation));
	}
	
	public boolean isEven() {
		int intIdTable = Integer.parseInt(idTable.toString());
		return ((intIdTable%2) == 0);
	}
	
	public void giveDiscount() {
		price = (price*80/100);
	}

	public boolean validatePrimeNumber() {
		Long[] prime = { 1L, 2L, 3L, 5L, 7L };

		for (int i = 0; i < prime.length; i++) {
			if (prime[i].equals(idTable)) {
				return true;
			}
		}
		return false;
	}
	
	public Reservation() {
	}

	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public Long getIdTable() {
		return idTable;
	}
	public void setIdTable(Long idTable) {
		this.idTable = idTable;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
