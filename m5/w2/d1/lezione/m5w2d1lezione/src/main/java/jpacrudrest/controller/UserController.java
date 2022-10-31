package jpacrudrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jpacrudrest.entities.Address;
import jpacrudrest.entities.User;
import jpacrudrest.services.AddressService;
import jpacrudrest.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService us;	
	
	@Autowired
	AddressService as;

	@GetMapping("/")
	//@ResponseBody		//Superfluo dall uso di rest controller
	public String index() {
		return "Ciao sono la home";
	}
	
	@GetMapping("/api/users")
	public List<User> allUsers() {
		return us.getAll();
	}
	
	@GetMapping("/api/users/{id}")
	public Optional<User> usersById(@PathVariable int id) {
		return us.getById(id);
	}
	
	@PostMapping("/api/users")
	public User postUser(
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			@RequestParam("address_id") int address_id			
			) {
		
		User u = new User();
		u.setName(name);
		u.setAge(age);
		Optional<Address> a = as.getById(address_id);
		if(a.isPresent()) {
			u.setAddress(a.get());
			
		}else {
			Optional<Address> a2 = as.getById(1);
			u.setAddress(a2.get());
		}
		
		us.addUser(u);
		
		return u;
	}
	
	@PutMapping("/api/users/{id}")
	public User putUser(
			@PathVariable("id") int id,
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			@RequestParam(name="address_id", required = false) Integer address_id
			) {
		
		Optional<User> u = us.getById(id);
		if(u.isPresent()) {
			User user= u.get();
			user.setName(name);
			user.setAge(age);						
			
			if(address_id != null) {
				Optional<Address> a = as.getById(address_id);
				if(a.isPresent()) {
					user.setAddress(a.get());
				}else {
					Optional<Address> a2= as.getById(1);
					user.setAddress(a2.get());
				}
			}
			us.addUser(user);
			return user;
		}
		
		
		return null;
	}

	@DeleteMapping("/api/users/{id}")
	public User delete(@PathVariable int id) {
		
		Optional<User> u = us.getById(id);
		
		if(u.isPresent()) {
			us.deleteById(id);
			return u.get();
		}
		
		return null;
	}

	@GetMapping("/api/users/name/{name}")
	public List<User> getUserByName(@PathVariable("name") String name){
		return us.getByName(name);
	}
}
