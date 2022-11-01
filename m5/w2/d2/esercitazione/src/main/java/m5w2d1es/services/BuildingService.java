package m5w2d1es.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m5w2d1es.Repositories.BuildingRepository;
import m5w2d1es.models.Building;

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
