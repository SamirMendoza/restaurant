package com.adn.restaurant.application.caseuse;

import org.springframework.stereotype.Service;

import com.adn.restaurant.application.command.ReservationCommand;
import com.adn.restaurant.domain.model.Reservation;
import com.adn.restaurant.domain.ports.ReservationRepository;
import com.adn.restaurant.domain.ports.TableRepository;

@Service
public class CreateReservation {
	
	private ReservationRepository reservationRepository;
	private TableRepository tableRepository;
	
	public CreateReservation(ReservationRepository reservationRepository, TableRepository tableRepository) {
		this.reservationRepository = reservationRepository;
		this.tableRepository = tableRepository;
	}
	
	public Reservation create(ReservationCommand reservationCommand) {
		Reservation reservation = new Reservation(reservationCommand.getIdTable(), reservationCommand.getDateRequest(), reservationCommand.getDateReservation(), reservationCommand.getPrice(), reservationCommand.getName());
		reservationRepository.save(reservation);
		tableRepository.save(tableRepository.findById(reservation.getIdTable()));
		
		return reservation;
	}
	
}
