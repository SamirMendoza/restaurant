package com.adn.restaurant.infrastructure.adapter.repository.database.mapper;

import java.util.ArrayList;
import java.util.List;

import com.adn.restaurant.domain.model.Reservation;
import com.adn.restaurant.infrastructure.adapter.repository.database.jpaentity.JpaReservation;



public class JpaReservationMapper {
	
    public static Reservation toReservation(JpaReservation jpaReservation) {
    	Reservation reservation = new Reservation();
    	
    	reservation.setCode(jpaReservation.getCode());
    	reservation.setIdTable(jpaReservation.getIdTable());
    	reservation.setPrice(jpaReservation.getPrice());
    	reservation.setName(jpaReservation.getName());
    	
    	return reservation;
    	
    }

    public static List<Reservation> toReservations(List<JpaReservation> jpaReservations){
    	 List<Reservation> reservations = new ArrayList<>();
    	 
    	 for (JpaReservation jpaReservation : jpaReservations) {
    		 reservations.add(toReservation(jpaReservation));
		}
    	 
    	 return reservations;
    }
    
    
    
    public static JpaReservation toJpaReservation(Reservation reservation) {
    	JpaReservation jpaReservation = new JpaReservation();
    	
    	jpaReservation.setCode(reservation.getCode());
    	jpaReservation.setIdTable(reservation.getIdTable());
    	jpaReservation.setPrice(reservation.getPrice());
    	jpaReservation.setName(reservation.getName());
    	
    	return jpaReservation;
    }
}

