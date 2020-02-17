package com.adn.restaurant.domain.model.validation;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public class ValidationReservation {
	
	public static boolean validacionPrimo(Long idMEsa, Date solicitud, Date reserva) {
		return (validarSiEsPrimo(idMEsa) && !validarDosOMasDiasEntreFechas(solicitud, reserva));
	}
	
	public static boolean validacionPar(Long idMesa, Date reserva) {
		return (validarEsPar(idMesa) && validarNoEsFinDeSemana(reserva));
	}
	
	public static boolean validacionImpar(Long idMesa, Date reserva) {
		return (!validarEsPar(idMesa) && !validarNoEsFinDeSemana(reserva));
	}
	
	private static boolean validarDosOMasDiasEntreFechas(Date solicitud, Date reserva) {
		
		LocalDate solicitudL = convertirDate(solicitud);
		LocalDate reservaL = convertirDate(reserva);
		
		for (int i = 0; i < 2; i++) {
			if (solicitudL.equals(reservaL)) {
				return false;
			} else {
				solicitudL = solicitudL.plusDays(1);
				i++;
			}
		}
		return true;
	}

	private static boolean validarNoEsFinDeSemana(Date reserva) {
		LocalDate fechaReserva = convertirDate(reserva);
		return (fechaReserva.getDayOfWeek() != DayOfWeek.SATURDAY && fechaReserva.getDayOfWeek() != DayOfWeek.SUNDAY);
	}
	
	private static boolean validarEsPar(Long idMesa) {
		return ((idMesa%2) == 0);
	}
	
	public static double darDescuento(double precio) {
		return (precio*0.8);
	}
	
	private static boolean validarSiEsPrimo(Long codigo) {
		Long[] primos = { 1L, 2L, 3L, 5L, 7L };

		for (int i = 0; i < primos.length; i++) {
			if (primos[i] == codigo) {
				return true;
			}
		}
		return false;
	}
	
	private static LocalDate convertirDate(Date dateToConvert) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return LocalDate.parse(format.format(dateToConvert));
	}
}
