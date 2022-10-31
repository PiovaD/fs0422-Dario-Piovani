package m5w2d1es.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m5w2d1es.Repositories.WorkstationRepository;
import m5w2d1es.models.Workstation;
import m5w2d1es.models.WorkstationType;

@Service
public class WorkstationService {

	@Autowired
	private WorkstationRepository wr;

	public List<Workstation> searchWorkstation(String city, WorkstationType type) {
		return wr.findByCityAndType(city, type);
	}

	public List<Workstation> searchAllWorkstations() {
		return wr.findAll();
	}

	public void create(Workstation workstation) {
		wr.save(workstation);
	}

	public Workstation findById(long id) {
		return wr.findById(id).get();
	}

	public void delete(long id) {
		wr.deleteById(id);
	}

}
