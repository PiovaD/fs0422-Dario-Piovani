package m5w2d3lez.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import m5w2d3lez.entities.User;
import m5w2d3lez.services.UserService;

public class UserController {

	@Autowired
	UserService us;

	@GetMapping()
	public Page<User> getAllAndPaginate(Pageable p) {
		return us.getAllAndPaginate(p);
	}

	@GetMapping("name/{name}")
	public Page<User> getByNameAndPaginate(@PathVariable("name") String name, Pageable p) {
		return us.getByNameAndPaginate(name, p);
	}

	@PostMapping
	public User postUser(@RequestParam("username") String username,
			@RequestParam(value = "birthDate", required = false) LocalDate birthDate) {
		User user = new User();
		user.setUsername(username);

		if (birthDate != null) {
			user.setBirth(birthDate);
		}

		us.addUser(user);
		return user;
	}
}
