package m5w2d1es.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m5w2d1es.Repositories.UserRepository;
import m5w2d1es.models.User;

@Service
public class UserService {

	@Autowired
	private UserRepository ur;

	public List<User> searchAllUsers() {
		return ur.findAll();
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
