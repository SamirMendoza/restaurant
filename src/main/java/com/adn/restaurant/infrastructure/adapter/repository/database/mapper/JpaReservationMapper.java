package com.adn.restaurant.infrastructure.adapter.repository.database.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.adn.restaurant.domain.model.Reservation;
import com.adn.restaurant.infrastructure.adapter.repository.database.jpaentity.JpaReservation;


@Mapper
public interface JpaReservationMapper {
	
	JpaReservationMapper MAPPER = Mappers.getMapper(JpaReservationMapper.class);

    Reservation toReservation(JpaReservation jpaReservation);

    List<Reservation> toReservations(List<JpaReservation> jpaReservations);

    JpaReservation toJpaReservation(Reservation reservation);
}

