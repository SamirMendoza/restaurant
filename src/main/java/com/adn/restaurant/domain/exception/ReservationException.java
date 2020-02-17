package com.adn.restaurant.domain.exception;

public class ReservationException extends RuntimeException{
		
	private static final long serialVersionUID = 5434659474424687483L;

		public ReservationException(String message) {
			super(message);
		}
}
