package deviceManagement.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import deviceManagement.Models.Role;
import deviceManagement.Repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository rr;

	public List<Role> getAll() {
		return rr.findAll();
	}

	public Page<Role> getAllPaginate(Pageable p) {
		return rr.findAll(p);
	}

	public Optional<Role> getById(Long id) {
		return rr.findById(id);
	}

	public void save(Role r) {
		rr.save(r);
	}

	public void delete(Long id) throws Exception {
		Optional<Role> r = rr.findById(id);
		
		if (r.isPresent()) {
			rr.delete(r.get());
		} else {
			throw new Exception("Ruolo non trovato");
		}
	}
}
