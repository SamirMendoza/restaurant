package com.adn.restaurant.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.adn.restaurant.RestaurantApplication;
import com.adn.restaurant.databuilder.ReservationTestDataBuilder;
import com.adn.restaurant.databuilder.TableTestDataBuilder;
import com.adn.restaurant.domain.model.Reservation;
import com.adn.restaurant.domain.model.Table;
import com.adn.restaurant.domain.ports.ReservationRepository;
import com.adn.restaurant.domain.ports.TableRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RestaurantApplication.class)
@TestPropertySource(properties = { "spring.config.location = classpath:application-test.yml" })
@AutoConfigureMockMvc
public class ReservationQueryControllerTest {
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;
	
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	Reservation reservation;
	
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Transactional
	@Rollback(true)
	@Test
	public void testGetTables() throws Exception {
		
		reservation = new ReservationTestDataBuilder().withIdTable(8L).build();
		reservationRepository.save(reservation);
		List<Reservation> reservations = new ArrayList<>();
		reservations=reservationRepository.findAll();
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/restaurant/reservations")
				.contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder)
				.andDo(print())
				.andExpect(status()
				.isOk())
				.andExpect(jsonPath("$[0].idTable", is(reservations.get(0).getIdTable().intValue() )));
	}
}
