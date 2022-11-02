package jpacrudrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jpacrudrest.entities.Address;
import jpacrudrest.entities.User;
import jpacrudrest.exceptions.PageException;
import jpacrudrest.services.AddressService;
import jpacrudrest.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService us;

	@Autowired
	AddressService as;

	@GetMapping("/")
	// @ResponseBody //Superfluo dall uso di rest controller
	public String index() {
		return "Ciao sono la home";
	}

	@GetMapping("/api/users")
	public Iterable<User> allUsers() {
		return us.getAll();
	}

	@GetMapping("/api/users/{id}")
	public Optional<User> usersById(@PathVariable int id) {
		return us.getById(id);
	}

	@PostMapping("/api/users")
	public User postUser(@RequestParam("name") String name, @RequestParam("age") int age,
			@RequestParam("address_id") int address_id) {

		User u = new User();
		u.setName(name);
		u.setAge(age);
		Optional<Address> a = as.getById(address_id);
		if (a.isPresent()) {
			u.setAddress(a.get());

		} else {
			Optional<Address> a2 = as.getById(1);
			u.setAddress(a2.get());
		}

		us.addUser(u);

		return u;
	}

	@PutMapping("/api/users/{id}")
	public User putUser(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("age") int age,
			@RequestParam(name = "address_id", required = false) Integer address_id) {

		Optional<User> u = us.getById(id);
		if (u.isPresent()) {
			User user = u.get();
			user.setName(name);
			user.setAge(age);

			if (address_id != null) {
				Optional<Address> a = as.getById(address_id);
				if (a.isPresent()) {
					user.setAddress(a.get());
				} else {
					Optional<Address> a2 = as.getById(1);
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

		if (u.isPresent()) {
			us.deleteById(id);
			return u.get();
		}

		return null;
	}

	@GetMapping("/api/users/name/{name}")
	public List<User> getUserByName(@PathVariable("name") String name) {
		return us.getByName(name);
	}

	@GetMapping("/api/users/re1")
	public ResponseEntity<String> re1() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("author", "Dario");

		String body = "corpo del responso";
		ResponseEntity<String> re = new ResponseEntity<String>(body, headers, HttpStatus.OK);

		return re;
	}

	@GetMapping("/api/users/re2/{mode}")
	public ResponseEntity<Object> re2(@PathVariable int mode) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("author", "Dario");

		switch (mode)
		{
		case 1:
			return new ResponseEntity<>("mode1", headers, HttpStatus.OK);

		case 2:
			return new ResponseEntity<>(us.getAll(), headers, HttpStatus.OK);

		default:
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/api/users/exc1")
	public String exc1() {
		throw new PageException("Eccezione magica");
	}
	
	@GetMapping("/api/users/exc2")
	public String exc2() {
		throw new ArrayIndexOutOfBoundsException("Eccezione ARRAY magica");
	}
	
	@GetMapping("/api/users/test1")
	public String test1() {
		return "ciao sono il test 1";
	}
	
	@GetMapping("/api/users/test2")
	public String test2() {
		return "ciao java sono il test 2";
	}
	
	@GetMapping("/api/users-paginate")
	public ResponseEntity<Page<User>> getAllAndPaginate(Pageable p){
		Page<User> res = us.getAllAndPaginate(p);
		if (res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}else {

			return new ResponseEntity<>(res, HttpStatus.OK);
		}
	}

	@GetMapping("/api/users-paginate-slice")
	public Page<User> getAllAndPaginateSlice(){
		Pageable pagina1_risultati2 = PageRequest.of(0, 2);
		Page<User> res = us.getAllAndPaginate(pagina1_risultati2);
		
		return res;
	}
	
	@GetMapping("/api/users-paginate-byname/{name}")
	public Page<User> getByNameAndPaginate(@PathVariable("name") String name, Pageable p){
		Page<User> res = us.getByNameAndPaginate(name,p);
		
		return res;
	}
}
