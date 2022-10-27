package m5w1d4lez;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import m5w1d4lez.entities.User;
import m5w1d4lez.services.UserService;

@SpringBootApplication
public class M5w1d4lezioneApplication implements CommandLineRunner{

	@Autowired
	UserService us;
	
	public static void main(String[] args) {
		SpringApplication.run(M5w1d4lezioneApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {		
		
//		insertUser(new User("Mario Rossi", 25, new Address("Via Roma")));
//		insertUser(new User("Luigi Verdi", 25, new Address("Via Milao")));
//		insertUser(new User("Wario Vossi", 25, new Address("Via Roma")));
		
//		printAllUsers();
		
		System.out.println(
		getByName("Luigi Verdi")
		);
		
	}
	
	public void printAllUsers() {
		System.out.println("Tutti gli user: " + us.getAll());
	}
	
	public void insertUser(User u) {
		us.addUser(u);
	}
	
	public List<User> getByName(String s){
		return us.getByName(s);
	}

}
