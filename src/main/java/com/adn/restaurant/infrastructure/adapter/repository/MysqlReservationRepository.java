package com.adn.restaurant.infrastructure.adapter.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.adn.restaurant.domain.model.Reservation;
import com.adn.restaurant.domain.ports.ReservationRepository;
import com.adn.restaurant.infrastructure.adapter.repository.database.jpaentity.JpaReservation;
import com.adn.restaurant.infrastructure.adapter.repository.database.jparepository.JpaReservationRepository;
import com.adn.restaurant.infrastructure.adapter.repository.database.mapper.JpaReservationMapper;


@Component
public class MysqlReservationRepository implements ReservationRepository {
	
	JpaReservationRepository jpaReservationRepository;
	
	public MysqlReservationRepository(JpaReservationRepository jpaReservationRepository) {
		this.jpaReservationRepository = jpaReservationRepository;
	}

	@Override
	public void save(Reservation reservation) {
		jpaReservationRepository.save(JpaReservationMapper.toJpaReservation(reservation));
	}

	@Override
	public List<Reservation> findAll() {
		
		List<Reservation> reservations = new ArrayList<>();
		List<JpaReservation> jpaReservations = jpaReservationRepository.findAll();
		jpaReservations.forEach(value -> reservations.add(JpaReservationMapper.toReservation(value)));
		return reservations;
	}

	@Override
	public Reservation findById(Long id) {
		return JpaReservationMapper.toReservation(jpaReservationRepository.findById(id).orElse(null));
	}

	@Override
	public void delete(Long id) {
		jpaReservationRepository.deleteById(id);
	}

	
	
}
