package gestionePrenotazioni.configs;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import gestionePrenotazioni.models.Booking;
import gestionePrenotazioni.models.User;
import gestionePrenotazioni.models.Workstation;

@Configuration
public class BookingConfig {
//	
//	@Autowired
//	@Qualifier("ws1")
//	Workstation w1;
//	
//	@Autowired
//	@Qualifier("ws2")
//	Workstation w2;
//	
//	@Autowired
//	@Qualifier("ws3")
//	Workstation w3;
//	
//	@Autowired
//	@Qualifier("ws4")
//	Workstation w4;
//	
//	@Autowired
//	@Qualifier("u1")
//	User u1;
//	
//	@Autowired
//	@Qualifier("u2")
//	User u2;
//
//	@Bean
//	@Scope("singleton")
//	public Booking newBooking1() {
//		return new Booking(LocalDate.now(), w1, u1);
//	}
//
//	@Bean
//	@Scope("singleton")
//	public Booking newBooking2() {
//		return new Booking(LocalDate.now(),w2, u1);
//	}
//
//	@Bean
//	@Scope("singleton")
//	public Booking newBooking3() {
//		return new Booking(LocalDate.now(), w1, u2);
//	}
//
//	@Bean
//	@Scope("singleton")
//	public Booking newBooking4() {
//		return new Booking(LocalDate.now(), w4, u2);
//	}
}
