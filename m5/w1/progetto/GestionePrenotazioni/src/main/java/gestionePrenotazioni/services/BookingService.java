package gestionePrenotazioni.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionePrenotazioni.Repositories.BookingRepository;
import gestionePrenotazioni.models.Booking;

@Service
public class BookingService {

	@Autowired
	private BookingRepository br;

	public List<Booking> searchAllBookings() {
		return br.findAll();
	}

	/*
	 * Una postazione può essere prenotata da un utente. La prenotazione vale per un
	 * solo giorno e può essere effettuata solo se per quel giorno la postazione
	 * risulta libera. Un utente può avere più prenotazioni in corso, ma non può
	 * prenotare più di una postazione per una particolare data.
	 */
	public void create(Booking booking) throws Exception {

		if (br.getByUserAndValidity(booking.getUser().getId(), booking.getValidity()).size() == 0) {

			if (br.getByWorkstationAndValidity(booking.getWorkstation().getId(), booking.getValidity())
					.size() < booking.getWorkstation().getMaxOccupants()) {

				br.save(booking);
			} else {
				throw new Exception(booking.getWorkstation() + " in data " + booking.getValidity() + " è al completo");
			}

		} else {
			throw new Exception(
					booking.getUser() + " ha già prenotato una postazione in data: " + booking.getValidity());
		}
	}

	public Booking findById(long id) {
		return br.findById(id).get();
	}

	public List<Booking> findByUserAndValidity(long userId, LocalDate time) {
		return br.getByUserAndValidity(userId, time);
	}

	public List<Booking> findByWorkstationAndValidity(long workstationId, LocalDate time) {
		return br.getByUserAndValidity(workstationId, time);
	}

	public void delete(long id) {
		br.deleteById(id);
	}

}
