package com.adn.restaurant.application.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.restaurant.application.commands.dto.ReservationDeleteCommand;
import com.adn.restaurant.application.commands.dto.ReservationSaveCommand;
import com.adn.restaurant.domain.model.Reservation;
import com.adn.restaurant.domain.ports.ReservationRepository;
import com.adn.restaurant.domain.ports.TableRepository;

@Service
public class ReservationCommandService {
	
	private ReservationRepository reservationRepository;
	private TableRepository tableRepository;
	
	@Autowired
	public ReservationCommandService(ReservationRepository reservationRepository, TableRepository tableRepository) {
		this.reservationRepository = reservationRepository;
		this.tableRepository = tableRepository;
	}

	public void create(ReservationSaveCommand reservationSaveCommand) {
		Reservation reservation = new Reservation(reservationSaveCommand.getIdTable(), reservationSaveCommand.getPrice(), reservationSaveCommand.getName());
		reservation.generateReservation(reservationSaveCommand.getDateRequest(), reservationSaveCommand.getDateReservation());
		reservationRepository.save(reservation);
		tableRepository.save(tableRepository.findById(reservationSaveCommand.getIdTable()));
	}
	
	public void delete(ReservationDeleteCommand reservationDeleteCommand) {
		reservationRepository.delete(reservationDeleteCommand.getId());
		tableRepository.save(tableRepository.findById(reservationDeleteCommand.getId()));
	}

	public ReservationCommandService() {
	}
}
