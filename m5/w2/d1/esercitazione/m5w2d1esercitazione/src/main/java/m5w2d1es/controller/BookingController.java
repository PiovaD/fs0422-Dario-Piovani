package m5w2d1es.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import m5w2d1es.models.Booking;
import m5w2d1es.services.BookingService;

@RestController
@Slf4j
public class BookingController {

	@Autowired
	private BookingService bs;

	@GetMapping("/api/bookings")
	public List<Booking> searchAllBookings() {
		return bs.searchAllBookings();
	}

	@GetMapping("/api/bookings/searchByUserAndValidity")
	public List<Booking> searchByUserAndValidity(@RequestParam Long id, @RequestParam LocalDate validity) {
		return bs.findByUserAndValidity(id, validity);
	}

	@PostMapping("/api/bookings")
	public void create(@RequestBody Booking booking) {
		try {
			bs.create(booking);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@GetMapping("/api/bookings/{id}")
	public Booking readById(@PathVariable Long id) {
		return bs.findById(id);
	}

	@PutMapping("/api/bookings")
	public void update(@RequestBody Booking booking) {
		try {
			bs.create(booking);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@DeleteMapping("/api/bookings/{id}")
	public void deleteById(@PathVariable Long id) {
		try {
			bs.delete(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

}
