package deviceManagement.controllers;

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

import deviceManagement.Models.Device;
import deviceManagement.Models.DeviceType;
import deviceManagement.Services.DeviceService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/devices")
public class DeviceController {

	
	@Autowired
	private DeviceService ds;
	
	@GetMapping("")
	public List<Device> getAllUsers() {
		return ds.getAll();
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Device>> getAllPageable(Pageable p) {
		Page<Device> findAll = ds.getAllPaginate(p);

		if (findAll.hasContent()) {
			return new ResponseEntity<>(findAll, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Device> readById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(ds.getById(id).get(), HttpStatus.OK);			
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/type/{id}")
	public ResponseEntity<Device> readByType(@PathVariable DeviceType type) {
		try {
			return new ResponseEntity<>(ds.getByType(type).get(), HttpStatus.OK);			
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/new")
	public void create(@RequestBody Device device) {
		try {
			ds.save(device);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@PutMapping("")
	public void update(@RequestBody Device device) {
		try {
			ds.save(device);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteById(@PathVariable Long id) {
		try {
			ds.delete(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
}
