package OtherServ.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import OtherServ.structures.Person;

@RestController
@RequestMapping("/app")
public class PageController {

	@RequestMapping(value = "/people", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getPeople() {
		List<Person> people = new ArrayList<>(Arrays.asList(
	            new Person("mario", "rossi", 40),
	            new Person("luigi", "verdi", 30),
	            new Person("peach", "rosi", 20),
	            new Person("yoshi", "bianchiverdi", 120)
	        ));
	        
	        return people.toString();
	}
}
