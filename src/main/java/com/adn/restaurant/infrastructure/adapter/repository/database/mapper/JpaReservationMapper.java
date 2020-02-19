package com.adn.restaurant.infrastructure.adapter.repository.database.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.adn.restaurant.domain.model.Reservation;
import com.adn.restaurant.infrastructure.adapter.repository.database.jpaentity.JpaReservation;


@Mapper(componentModel = "spring")
public interface JpaReservationMapper {
	
    Reservation toReservation(JpaReservation jpaReservation);

    List<Reservation> toReservations(List<JpaReservation> jpaReservations);

    JpaReservation toJpaReservation(Reservation reservation);
}

