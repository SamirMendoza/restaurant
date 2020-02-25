//package com.adn.restaurant.integration;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.time.LocalDate;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.adn.restaurant.RestaurantApplication;
//import com.adn.restaurant.application.commands.dto.ReservationSaveCommand;
//import com.adn.restaurant.databuilder.ReservationSaveCommandTestDataBuilder;
//import com.adn.restaurant.databuilder.ReservationTestDataBuilder;
//import com.adn.restaurant.domain.model.Reservation;
//import com.adn.restaurant.domain.ports.ReservationRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import org.springframework.test.annotation.Rollback;
//
//import javax.transaction.Transactional;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = RestaurantApplication.class)
//@TestPropertySource(properties = { "spring.config.location = classpath:application-test.yml" })
//@AutoConfigureMockMvc
//public class ReservationCommandRestControllerTest {
//
//	
//	@Autowired
//	private WebApplicationContext context;
//	private MockMvc mockMvc;
//	
//	
//	@Autowired
//	private ReservationRepository reservationRepository;
//	
//	Reservation reservation;
//	ReservationSaveCommand reservationSaveCommand;
//	
//	@BeforeEach
//	public void setup() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//	}
//	
//	@Transactional
//	@Rollback(true)
//	@Test
//	public void saveReservationTest() throws Exception {
//		reservation = new ReservationTestDataBuilder().withCode(11L).withIdTable(11L).withPrice(700).withName("stefy").build();
//		reservationSaveCommand = new ReservationSaveCommandTestDataBuilder().withIdTable(11L).withPrice(700).withName("stefy")
//									.withDateReservation(LocalDate.of(2020, 02, 21)).withDateReques(LocalDate.of(2020, 02, 17)).build();
//		reservationRepository.save(reservation);
//		ObjectMapper objMap = new ObjectMapper();
//		ObjectWriter objectWriter = objMap.writer().withDefaultPrettyPrinter();
//		mockMvc.perform(post("/restaurant/reservations/create")
//			.contentType(MediaType.APPLICATION_JSON)
//			.content(objectWriter.writeValueAsString(reservationSaveCommand)))
//			.andExpect(status().isOk());
//	}
//	
//	
//}