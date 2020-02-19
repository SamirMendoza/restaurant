package com.adn.restaurant.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.adn.restaurant.application.caseuse.DeleteReservation;
import com.adn.restaurant.application.caseuse.FindTable;
import com.adn.restaurant.domain.ports.ReservationRepository;
import com.adn.restaurant.domain.ports.TableRepository;
import com.adn.restaurant.infrastructure.adapter.repository.MysqlReservationRepository;
import com.adn.restaurant.infrastructure.adapter.repository.MysqlTableRepository;
import com.adn.restaurant.infrastructure.adapter.repository.database.jparepository.JpaReservationRepository;
import com.adn.restaurant.infrastructure.adapter.repository.database.jparepository.JpaTableRepository;


@Configuration
public class CaseUseConfiguration {
	
	@Primary
	@Bean
	public ReservationRepository reservationRepository(JpaReservationRepository jpaReservationRepository) {
		return new MysqlReservationRepository(jpaReservationRepository);
	}
	
	@Primary
	@Bean
	public TableRepository tableRepository(JpaTableRepository jpaTableRepository) {
		return new MysqlTableRepository(jpaTableRepository);
	}
	
//	@Bean
//	public FindTable findTable(TableRepository tableRepository) {
//		return new FindTable(tableRepository);
//	}
	
	@Bean
	public DeleteReservation deleteReservation(ReservationRepository reservationRepository, TableRepository tableRepository) {
		return new DeleteReservation(reservationRepository, tableRepository);
	}
}
