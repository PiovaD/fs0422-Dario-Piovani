package gestionePrenotazioni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionePrenotazioni.Repositories.UserRepository;
import gestionePrenotazioni.models.User;

@Service
public class UserService {

	@Autowired
	private UserRepository ur;

	public List<User> searchAllUsers() {
		return (List<User>) ur.findAll();
	}

	public void create(User user) {
		ur.save(user);
	}

	public User findById(long id) {
		return ur.findById(id)
				.get();
	}

	public void delete(long id) {
		ur.deleteById(id);
	}
}
