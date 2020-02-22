package com.adn.restaurant.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.adn.restaurant.application.querys.ReservationQueryService;
import com.adn.restaurant.databuilder.ReservationTestDataBuilder;
import com.adn.restaurant.domain.model.Reservation;
import com.adn.restaurant.domain.ports.ReservationRepository;

public class ReservationQueryServiceTest {
	
	private ReservationQueryService reservationQueryService;
	
	@Mock
	private ReservationRepository reservationRepository;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.reservationQueryService = new ReservationQueryService(reservationRepository);
	}
	
	
	@Test
	public void findAllTest() {
		//arrange
		List<Reservation> reservations= new ArrayList<>();
		reservations.add(new ReservationTestDataBuilder().withCode(3L).build());
		reservations.add(new ReservationTestDataBuilder().withCode(6L).build());
		when(this.reservationRepository.findAll()).thenReturn(reservations);
		
		//act
		List<Reservation> reservationsResponse = this.reservationQueryService.findAll();
		
		//assert
		Assertions.assertEquals(reservations.size(), reservationsResponse.size());
		Assertions.assertEquals(3L, reservationsResponse.get(0).getCode().longValue());
		Assertions.assertEquals(6L, reservationsResponse.get(1).getCode().longValue());
	}
}
