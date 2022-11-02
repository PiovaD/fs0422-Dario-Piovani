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
import m5w2d1es.models.User;
import m5w2d1es.services.UserService;

@RestController
@Slf4j
public class UserController {

	@Autowired
	private UserService us;
	
	@GetMapping("/")
	public String index() {
		return "Ciao sono la home";
	}

	@GetMapping("/api/users")
	public List<User> searchAllUsers() {
		return us.searchAllUsers();
	}

	@PostMapping("/api/users")
	public void create(@RequestBody User user) {
		try {
			us.create(user);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@GetMapping("/api/users/{id}")
	public User readById(@PathVariable Long id) {
		try {
			return us.findById(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@PutMapping("/api/users")
	public void update(@RequestBody User user) {
		try {
			us.create(user);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@DeleteMapping("/api/users/{id}")
	public void deleteById(@PathVariable Long id) {
		try {
			us.delete(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
}