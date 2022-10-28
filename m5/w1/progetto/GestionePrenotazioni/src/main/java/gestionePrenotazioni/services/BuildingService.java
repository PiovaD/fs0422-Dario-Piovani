package gestionePrenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionePrenotazioni.Repositories.BuildingRepository;
import gestionePrenotazioni.models.Building;

@Service
public class BuildingService {

	@Autowired
	private BuildingRepository br;

	public List<Building> searchAllBuildings() {
		return br.findAll();
	}

	public void create(Building building) {
		br.save(building);
	}

	public Building findById(long id) {
		return br.findById(id)
				.get();
	}

	public void delete(long id) {
		br.deleteById(id);
	}
}
