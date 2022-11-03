package m5w2d4lez.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m5w2d4lez.entities.Role;
import m5w2d4lez.repositories.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository rr;

	public Iterable<Role> getAll() {        
		return rr.findAll();
    }
    public void addRole(Role r) {
        rr.save(r);
    }
    public Optional<Role> getById(int id) {
        return rr.findById(id);
    }
}
