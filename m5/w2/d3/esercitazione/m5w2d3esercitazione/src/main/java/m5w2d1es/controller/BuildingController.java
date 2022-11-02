package m5w2d1es.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import m5w2d1es.models.Building;
import m5w2d1es.services.BuildingService;

@RestController
@Slf4j
public class BuildingController {

	@Autowired
	private BuildingService bs;

	@GetMapping("/api/buildings")
	public List<Building> searchAllBuildings() {
		return bs.searchAllBuildings();
	}

	@PostMapping("/api/buildings")
	public void create(@RequestBody Building building) {
		try {
			bs.create(building);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@GetMapping("/api/buildings/{id}")
	public Building readById(@PathVariable Long id) {
		try {
			return bs.findById(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@PutMapping("/api/buildings")
	public void update(@RequestBody Building building) {
		try {
			bs.create(building);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@DeleteMapping("/api/buildings/{id}")
	public void deleteById(@PathVariable Long id) {
		try {
			bs.delete(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
