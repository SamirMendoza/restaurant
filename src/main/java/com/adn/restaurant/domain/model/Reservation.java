package com.adn.restaurant.domain.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

import com.adn.restaurant.domain.utils.AdditionalMethods;

public class Reservation {
	
	private Long code;
	private Long idTable;
	private Date dateRequest;
	private Date dateReservation;
	private double price;
	private String name;
	
	public Reservation(Long idTable, Date dateRequest, Date dateReservation, double price, String name) {

		if (!validatePrimeIdTable()) {
			//lanzar excepcion
		}
		
		if (!validateEvenIdTable()) {
			giveDiscount();
		}
		
		if (!validateUnevenIdTable()) {
			//lanzar excepcion
		}
		
		this.idTable = idTable;
		this.dateRequest = dateRequest;
		this.dateReservation = dateReservation;
		this.price = price;
		this.name = name;
	}
	
	public boolean validatePrimeIdTable() {
		return (validatePrimeNumber() && validateDaysBetweenDates());
	}
	
	public boolean validateEvenIdTable() {
		return (isEven() && validateNoWeekend());
	}
	
	public boolean validateUnevenIdTable() {
		return (!isEven() && !validateNoWeekend());
	}
	
	public boolean validateNoWeekend() {
		LocalDate dateReservationLocalDate = AdditionalMethods.toLocalDate(dateReservation);
		return (dateReservationLocalDate.getDayOfWeek() != DayOfWeek.SATURDAY && dateReservationLocalDate.getDayOfWeek() != DayOfWeek.SUNDAY);
	}
	
	public boolean validateDaysBetweenDates() {
		
		LocalDate dateRequestLocalDate = AdditionalMethods.toLocalDate(dateRequest);
		LocalDate dateReservationLocalDate = AdditionalMethods.toLocalDate(dateReservation);
		
		if (dateRequestLocalDate.isEqual(dateReservationLocalDate))
			return false;
		
		dateRequestLocalDate = dateRequestLocalDate.plusDays(1);
		
		return (!dateRequestLocalDate.isEqual(dateReservationLocalDate));
	}
	
	public boolean isEven() {
		return ((idTable%2) == 0);
	}
	
	public void giveDiscount() {
		price = (price*0.8);
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
	public Date getDateRequest() {
		return dateRequest;
	}
	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
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
