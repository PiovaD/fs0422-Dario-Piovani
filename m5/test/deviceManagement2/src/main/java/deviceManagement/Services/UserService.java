package deviceManagement.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import deviceManagement.Models.User;
import deviceManagement.Repositories.UserRepository;

@Service
public class UserService {	
	
    @Autowired
    PasswordEncoder encoder;

	@Autowired
	UserRepository ur;
	
	public List<User> getAll() {
		return ur.findAll();
	}

	public Page<User> getAllPaginate(Pageable p) {
		return ur.findAll(p);
	}

	public Optional<User> getById(Long id) {
		return ur.findById(id);
	}

	public Optional<User> getByUsername(String username) {
		return ur.findByUsername(username);
	}

	public void save(User u) {
		String psw = u.getPassword();
		u.setPassword(encoder.encode(psw));
		ur.save(u);
	}

	public void delete(Long id) throws Exception {
		Optional<User> u = ur.findById(id);
		if(u.isPresent()) {
		ur.delete(u.get());
		} else {
			throw new Exception("Utente non trovato");
		}
	}

	public void update(User u) {
		ur.save(u);		
	}

}
