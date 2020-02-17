package com.adn.restaurant.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adn.restaurant.application.caseuse.CreateReservation;
import com.adn.restaurant.infrastructure.adapter.repository.MysqlReservationRepository;
import com.adn.restaurant.infrastructure.adapter.repository.MysqlTableRepository;


@Configuration
public class BeanConfiguration {
	
	@Bean
	public CreateReservation getCreateReservation(MysqlReservationRepository mysqlReservationRepository, MysqlTableRepository mysqlTableRepository) {
		return new CreateReservation(mysqlReservationRepository, mysqlTableRepository);
	}
	
}
