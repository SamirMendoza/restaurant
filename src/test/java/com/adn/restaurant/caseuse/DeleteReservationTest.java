package com.adn.restaurant.caseuse;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.adn.restaurant.application.caseuse.DeleteReservation;
import com.adn.restaurant.databuilder.ReservationTestDataBuilder;
import com.adn.restaurant.domain.model.Reservation;
import com.adn.restaurant.domain.ports.ReservationRepository;
import com.adn.restaurant.domain.ports.TableRepository;

public class DeleteReservationTest {
	
	private DeleteReservation deleteReservation;
	
	@Mock
	private ReservationRepository reservationRepository;
	@Mock
	private TableRepository tableRepository;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.deleteReservation = new DeleteReservation(this.reservationRepository, this.tableRepository);
	}
	
	@Test
	public void deleteTest() {
		//arrange
		Long id = 7L;
		
		Reservation reservation = new ReservationTestDataBuilder().withCode(id).withName("jose").build();
		when(this.reservationRepository.delete(id)).thenReturn(null);
		//act
		reservation = deleteReservation.delete(id);
		//assert
		Assertions.assertNull(reservation);
		
	}
	
}
