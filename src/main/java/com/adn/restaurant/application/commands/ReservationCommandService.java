package com.adn.restaurant.application.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.restaurant.application.commands.dto.ReservationDeleteCommandDto;
import com.adn.restaurant.application.commands.dto.ReservationSaveCommandDto;
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

	public void create(ReservationSaveCommandDto reservationSaveCommandDto) {
		Reservation reservation = new Reservation(reservationSaveCommandDto.getIdTable(), reservationSaveCommandDto.getPrice(), reservationSaveCommandDto.getName());
		reservation.generateReservation(reservationSaveCommandDto.getDateRequest(), reservationSaveCommandDto.getDateReservation());
		reservationRepository.save(reservation);
		tableRepository.save(tableRepository.findById(reservationSaveCommandDto.getIdTable()));
	}
	
	public void delete(ReservationDeleteCommandDto reservationDeleteCommandDto) {
		reservationRepository.delete(reservationDeleteCommandDto.getId());
		tableRepository.save(tableRepository.findById(reservationDeleteCommandDto.getId()));
	}

	public ReservationCommandService() {
	}
}
