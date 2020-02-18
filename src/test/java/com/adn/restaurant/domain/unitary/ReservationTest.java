package com.adn.restaurant.domain.unitary;

import org.junit.jupiter.api.Test;

import com.adn.restaurant.domain.databuilder.ReservationTestDataBuilder;
import com.adn.restaurant.domain.model.Reservation;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class ReservationTest {

	    @Test
	    public void isNumberPrime() {

	    	Reservation reservation = new ReservationTestDataBuilder().withIdTable(7L).build();

	    	Boolean primeNumber = reservation.validatePrimeNumber();

	    	assertTrue(primeNumber);
	    }
	    
	    @Test
	    public void notIsNumberPrime() {
	    	
	    	Reservation reservation = new ReservationTestDataBuilder().withIdTable(8L).build();
	    	
	    	Boolean notPrimeNumber = reservation.validatePrimeNumber();
	    	
	    	assertFalse(notPrimeNumber);
	    }
	    
	    @Test
	    public void giveDiscount() {
	    	
	    	Reservation reservation = new ReservationTestDataBuilder().withPrice(1000).build();
	    	
	    	reservation.giveDiscount();
	    	double priceWithDiscount = reservation.getPrice();
	    	
	    	assertEquals(800, priceWithDiscount);
	    }
	    
	    @Test
	    public void isNumberEven() {

	    	Reservation reservation = new ReservationTestDataBuilder().withIdTable(8L).build();

	    	Boolean evenNumber = reservation.isEven();

	    	assertTrue(evenNumber);
	    }
	    
	    @Test
	    public void isNumberUneven() {
	    	
	    	Reservation reservation = new ReservationTestDataBuilder().withIdTable(7L).build();
	    	
	    	Boolean unevenNumber = reservation.isEven();
	    	
	    	assertFalse(unevenNumber);
	    }
	    
	    @Test
	    public void betweenThreeOrMoreDays() {
	    	
	    	Reservation reservation = new ReservationTestDataBuilder().build();
	    	LocalDate dateRequest = LocalDate.of(2020, 2, 17);
	    	LocalDate dateReservation = LocalDate.of(2020, 2, 22);

	    	
	    	Boolean threeOrMoreDays = reservation.validateDaysBetweenDates(dateRequest, dateReservation);
	    	
	    	assertTrue(threeOrMoreDays);
	    }
	    
	    @Test
	    public void betweenTwoOrLessDays() {
	    	
	    	Reservation reservation = new ReservationTestDataBuilder().build();
	    	LocalDate dateRequest = LocalDate.of(2020, 2, 17);
	    	LocalDate dateReservation = LocalDate.of(2020, 2, 18);
	    	
	    	Boolean twoOrLessDays = reservation.validateDaysBetweenDates(dateRequest, dateReservation);
	    	
	    	assertFalse(twoOrLessDays);
	    }
	    
	    @Test
	    public void notIsWeekEnd() {
	    	
	    	Reservation reservation = new ReservationTestDataBuilder().build();
	    	LocalDate dateReservation = LocalDate.of(2020, 2, 17);

	    	
	    	Boolean midWeek = reservation.validateNoWeekend(dateReservation);
	    	
	    	assertTrue(midWeek);
	    }
	    
	    @Test
	    public void isWeekEnd() {
	    	
	    	Reservation reservation = new ReservationTestDataBuilder().build();
	    	LocalDate dateReservation = LocalDate.of(2020, 2, 22);
	    	
	    	Boolean isWeekEnd = reservation.validateNoWeekend(dateReservation);
	    	
	    	assertFalse(isWeekEnd);
	    }
	    
	    
}
