package com.adn.restaurant.application.caseuse;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.adn.restaurant.application.command.ReservationCommand;
import com.adn.restaurant.domain.model.Reservation;
import com.adn.restaurant.domain.ports.ReservationRepository;
import com.adn.restaurant.domain.ports.TableRepository;

public class CreateReservation {
	
	private ReservationRepository reservationRepository;
	private TableRepository tableRepository;
	
	public CreateReservation(ReservationRepository reservationRepository, TableRepository tableRepository) {
		this.reservationRepository = reservationRepository;
		this.tableRepository = tableRepository;
	}
	
	public Reservation create(ReservationCommand reservationCommand, LocalDate dateReservation) {
		Reservation reservation = new Reservation(reservationCommand.getIdTable(), reservationCommand.getPrice(), reservationCommand.getName());
		reservation.generateReservation(LocalDate.now(), dateReservation);
		reservationRepository.save(reservation);		
		return reservation;
	}
	
}
