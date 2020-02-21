//package com.adn.restaurant.caseuse;
//
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDate;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import com.adn.restaurant.databuilder.ReservationCommandTestDataBuilder;
//import com.adn.restaurant.databuilder.ReservationTestDataBuilder;
//import com.adn.restaurant.domain.model.Reservation;
//import com.adn.restaurant.domain.ports.ReservationRepository;
//import com.adn.restaurant.domain.ports.TableRepository;
//
//public class CreateReservationTest {
//	
//	private CreateReservation createReservation;
//	
//	@Mock
//	private ReservationRepository reservationRepository;
//	private TableRepository tableRepository;
//	
//	@BeforeEach
//	public void setup() {
//		MockitoAnnotations.initMocks(this);
//		this.createReservation = new  CreateReservation(reservationRepository, tableRepository);
//	}
//	
//	@Test
//	public void createTest() {
//		//arrange
//		LocalDate dateReservation = LocalDate.now();
//		dateReservation = dateReservation.plusDays(7);
//		
//		Reservation reservation = new ReservationTestDataBuilder().withName("julio").withIdTable(8L).build();
//		ReservationCommand reservationCommand = new ReservationCommandTestDataBuilder().withName("julio").withIdTable(8L).build();
//		doNothing().when(this.reservationRepository).save(reservation);
//		//act
//		Reservation reservationResponse = createReservation.create(reservationCommand, dateReservation);
//		//assert
//		Assertions.assertEquals("julio", reservationResponse.getName());
//		Assertions.assertEquals(8L, reservationResponse.getIdTable());
//	}
//	
//	
//}
