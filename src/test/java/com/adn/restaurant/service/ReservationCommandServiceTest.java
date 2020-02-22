package com.adn.restaurant.service;

import static org.mockito.Mockito.doNothing;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.adn.restaurant.application.commands.ReservationCommandService;
import com.adn.restaurant.application.commands.dto.ReservationDeleteCommand;
import com.adn.restaurant.application.commands.dto.ReservationSaveCommand;
import com.adn.restaurant.databuilder.ReservationDeleteCommandTestDataBuilder;
import com.adn.restaurant.databuilder.ReservationSaveCommandTestDataBuilder;
import com.adn.restaurant.domain.model.Reservation;
import com.adn.restaurant.domain.ports.ReservationRepository;
import com.adn.restaurant.domain.ports.TableRepository;

public class ReservationCommandServiceTest {
	
	private ReservationCommandService reservationCommandService;
	
	@Mock
	private ReservationRepository reservationRepository;
	@Mock
	private TableRepository tableRepository;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.reservationCommandService = new ReservationCommandService(this.reservationRepository, this.tableRepository);
	}
	
	
	@Test
	public void createTest() {
		//arrange
		LocalDate dateReservation = LocalDate.of(2020, 2, 28);
		LocalDate dateRequest = LocalDate.of(2020, 2, 24);
		
		ReservationSaveCommand reservationSaveCommand = new ReservationSaveCommandTestDataBuilder().withName("julio").withIdTable(8L).withDateReques(dateRequest).withDateReservation(dateReservation).build();
		ArgumentCaptor<Reservation> valueCapture = ArgumentCaptor.forClass(Reservation.class);				
		doNothing().when(this.reservationRepository).save(valueCapture.capture());
		
		//act
		reservationCommandService.create(reservationSaveCommand);
		
		//assert
		Assertions.assertEquals(8L, valueCapture.getValue().getIdTable());
		Assertions.assertEquals("julio", valueCapture.getValue().getName());
		
	}
	
	@Test
	public void deleteTest() {
		//arrange
		Long id = 7L;
		ReservationDeleteCommand reservationDeleteCommand = new ReservationDeleteCommandTestDataBuilder().withId(id).build();
		ArgumentCaptor<Long> valueCapture = ArgumentCaptor.forClass(Long.class);
		doNothing().when(this.reservationRepository).delete(valueCapture.capture());
		
		//act
		reservationCommandService.delete(reservationDeleteCommand);
		
		//assert
		Assertions.assertEquals(id, valueCapture.getValue());
		
	}
}
