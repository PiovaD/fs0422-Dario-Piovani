package m5w2d4lez.controllers;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m5w2d4lez.entities.Role;
import m5w2d4lez.entities.RoleType;
import m5w2d4lez.entities.User;
import m5w2d4lez.services.RoleService;
import m5w2d4lez.services.UserService;

@RestController
@RequestMapping("/app")
public class PageController {

	@Autowired
	UserService us;

	@Autowired
	RoleService rs;

	@GetMapping("/add-user")
	public String addUser() {

		User user = new User();

		user.setFirstName("Carlo");
		user.setLastName("Rossi");
		user.setUsername("lerooy");
		user.setBirthDate(new GregorianCalendar(1990, 10, 8));
		user.setActive(true);
		user.setEmail("lerooy@jankis.com");
		user.setPassword("test");

		Set<Role> roles = new HashSet<>();

		Role admin = rs.getById(1).get();

		roles.add(admin);

		user.setRoles(roles);

		us.addUser(user);

		return "User added";

	}

	@GetMapping("/add-roles")
	public String addRoles() {
		Role admin = new Role();
		admin.setRoleType(RoleType.ROLE_ADMIN);
		rs.addRole(admin);

		Role user = new Role();
		user.setRoleType(RoleType.ROLE_USER);
		rs.addRole(user);

		return "Roles added";
	}
	
	@GetMapping("/protected")
	@PreAuthorize("hasRole('ADMIN')")
	public String metodoAuth1() {
		return "ciao Elon benvenuto su twitter";
	}
	
	@GetMapping("/user/{username}")
	@PreAuthorize("hasRole('ADMIN')")
	public User getByUsername(@PathVariable("username") String un) {
		Optional<User> u =  us.getByUsername(un);
		
		if (u.isPresent()) {
			return u.get();
		}		
		
		return null;
	}
	
	
	@GetMapping("/auth-info")
	@PreAuthorize("hasRole('ADMIN')")
	public String getAuthInfo() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			UserDetails u = ((UserDetails) principal);
			User user = us.getByUsername(u.getUsername()).get();
            return String.format("id:%d, email:%s, active:%b", user.getId(), user.getEmail(), user.getActive());
			
		}
		return null;
	}
}
