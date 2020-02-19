package com.adn.restaurant.caseuse;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.adn.restaurant.application.caseuse.FindReservation;
import com.adn.restaurant.databuilder.ReservationTestDataBuilder;
import com.adn.restaurant.domain.model.Reservation;
import com.adn.restaurant.domain.ports.ReservationRepository;

public class FindReservationTest {
	
	private FindReservation findReservation;
	
	@Mock
	ReservationRepository reservationRepository;
	
	@BeforeEach
	public void setup() {
        MockitoAnnotations.initMocks(this);
		this.findReservation = new FindReservation(reservationRepository);
	}
	
	@Test
	public void findAllTest() {
		//arrange
		List<Reservation> reservations= new ArrayList<>();
		reservations.add(new ReservationTestDataBuilder().withCode(3L).build());
		reservations.add(new ReservationTestDataBuilder().withCode(6L).build());
		when(this.reservationRepository.findAll()).thenReturn(reservations);
		//act
		List<Reservation> reservationsResponse = this.findReservation.findAll();
		
		//assert

		Assertions.assertEquals(reservations.size(), reservationsResponse.size());
		Assertions.assertEquals(3L, reservationsResponse.get(0).getCode().longValue());
		Assertions.assertEquals(6L, reservationsResponse.get(1).getCode().longValue());
	}
	
	@Test
	public void findByIdTest() {
		Long id = 8L;
		
		Reservation reservation = new ReservationTestDataBuilder().withCode(id).withName("jose").build();
		when(this.reservationRepository.findById(id)).thenReturn(reservation);
		
		Reservation reservationResponse = this.findReservation.findById(reservation.getCode());
		
		Assertions.assertEquals(reservation, reservationResponse);

	}
}
