package com.adn.restaurant.infrastructure.adapter.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.adn.restaurant.domain.model.Reservation;
import com.adn.restaurant.domain.ports.ReservationRepository;
import com.adn.restaurant.infrastructure.adapter.repository.database.jparepository.JpaReservationRepository;
import com.adn.restaurant.infrastructure.adapter.repository.database.mapper.JpaReservationMapper;


@Repository
@Transactional
public class MysqlReservationRepository implements ReservationRepository {
	
	JpaReservationRepository jpaReservationRepository;
	
	public MysqlReservationRepository() {
	}
	
	public MysqlReservationRepository(JpaReservationRepository jpaReservationRepository) {
		this.jpaReservationRepository = jpaReservationRepository;
	}

	@Override
	public void save(Reservation reservation) {
		jpaReservationRepository.save(JpaReservationMapper.toJpaReservation(reservation));
	}

	@Override
	public List<Reservation> findAll() {
		return JpaReservationMapper.toReservations(jpaReservationRepository.findAll());
	}

	@Override
	public Reservation findById(Long id) {
		return JpaReservationMapper.toReservation(jpaReservationRepository.findById(id).orElse(null));
	}

	@Override
	public Reservation delete(Long id) {
		jpaReservationRepository.deleteById(id);
		return findById(id);
	}

	
	
}
