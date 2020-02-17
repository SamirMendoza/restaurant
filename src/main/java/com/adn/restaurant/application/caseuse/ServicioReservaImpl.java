//package com.adn.restaurant.application.caseuse;
//
//import java.util.List;
//
//import com.adn.restaurant.domain.exception.ReservationException;
//import com.adn.restaurant.domain.model.Reservation;
//import com.adn.restaurant.domain.model.validation.ValidationReservation;
//import com.adn.restaurant.domain.ports.ReservationRepository;
//import com.adn.restaurant.domain.ports.TableRepository;
//
//
//public class ServicioReservaImpl{
//
//	private static final String CREADO = "Creado Exitosamente";
//	private static final String NO_CREAR_FIN_SEMANA_IMPAR = "No es posible realizar la reserva para el fin de semana, porque la mesa es Impar";
//	private static final String NO_CREAR_PRIMOS_SIN_ANTELACION = "No es posible realizar la reserva, porque la mesa es numero primo y no cuenta con minimo 3 dias de antelacion";
//
//	
//	private ReservationRepository repositorioReserva;
//	private TableRepository repositorioMesa;
//
//	public ServicioReservaImpl(ReservationRepository repositorioReserva, TableRepository repositorioMesa) {
//		this.repositorioReserva = repositorioReserva;
//		this.repositorioMesa = repositorioMesa;
//	}
//	
//	@Override
//	public String create(Reservation reserva) {
//		try {
//			if (ValidationReservation.validacionPrimo(reserva.getIdMesa(), reserva.getFechaSolicitud(), reserva.getFechaReserva()))
//				throw new ReservationException(NO_CREAR_PRIMOS_SIN_ANTELACION);
//					
//			if (ValidationReservation.validacionImpar(reserva.getIdMesa(), reserva.getFechaReserva()))
//				throw new ReservationException(NO_CREAR_FIN_SEMANA_IMPAR);
//			
//			if (ValidationReservation.validacionPar(reserva.getIdMesa(), reserva.getFechaReserva()))
//				reserva.setPrecio(ValidationReservation.darDescuento(reserva.getPrecio()));
//			
//			repositorioReserva.save(reserva);
//			repositorioMesa.actualizarEstado(reserva.getIdMesa(), false);
//			return CREADO;
//			
//		}catch(Exception e){
//			return "Error: "+e.getMessage();
//		}
//	}
//
//	@Override
//	public List<Reservation> findAll() {
//		return repositorioReserva.findAll();
//	}
//}
