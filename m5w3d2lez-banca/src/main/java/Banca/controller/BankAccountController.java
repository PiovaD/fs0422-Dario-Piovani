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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Banca.entity.BankAccount;
import Banca.services.BankAccountService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/bank-account")
public class BankAccountController {

	
	@Autowired
	private BankAccountService bas;

	@GetMapping("")
	public List<BankAccount> getAllBankAccounts() {
		return bas.getAll();
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<BankAccount>> getAllPageable(Pageable p) {
		Page<BankAccount> findAll = bas.getAllPaginate(p);

		if (findAll.hasContent()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<BankAccount> getById(@PathVariable Long id) {

		return new ResponseEntity<>(bas.getById(id), HttpStatus.OK);

	}


	@PostMapping("/new")
	public void create(@RequestParam(value = "user_id", required = false) Long id) {
		try {
			bas.save(new BankAccount());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@PutMapping("")
	public void update(@RequestBody BankAccount bankAcount) {
		try {
			bas.save(bankAcount);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteById(@PathVariable Long id) {
		try {
			bas.deleteById(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
