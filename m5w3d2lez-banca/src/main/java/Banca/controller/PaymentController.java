package Banca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Banca.entity.Payment;
import Banca.services.PaymentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	
	@Autowired
	private PaymentService ps;

	@GetMapping("")
	public List<Payment> getAllPayments() {
		return ps.getAll();
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<Payment>> getAllPageable(Pageable p) {
		Page<Payment> findAll = ps.getAllPaginate(p);

		if (findAll.hasContent()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Payment> getById(@PathVariable Long id) {

		return new ResponseEntity<>(ps.getById(id), HttpStatus.OK);

	}


	@PostMapping("/new")
	public void create(@RequestBody Payment payment) {
		try {
			ps.save(payment);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@PutMapping("")
	public void update(@RequestBody Payment payment) {
		try {
			ps.save(payment);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteById(@PathVariable Long id) {
		try {
			ps.deleteById(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}