package m5w1d4lez;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import m5w1d4lez.entities.User;
import m5w1d4lez.repositories.JdbcAddressRepository;
import m5w1d4lez.repositories.JdbcUserRepository;

@SpringBootApplication
public class M5w1d4lezioneApplication implements CommandLineRunner {

	@Autowired
	JdbcUserRepository ur;

	@Autowired
	JdbcAddressRepository ar;

	public static void main(String[] args) {
		SpringApplication.run(M5w1d4lezioneApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("il n° di user è: " + ur.count());

		// insert("Mario Rossi", 20, 1);
		// insert("Luigi Verdi", 18, 2);

		// insertAddress("Via Milano");
		// insertAddress("Via Roma");

		findAll();
		
		findById(1);
		
		//User u = ur.findById(1);
				
		//updateUser(u, "Carlo Cracco", 9);
		
		deleteById(1);
		
		System.out.println("Utenti con nome luigi sono: ");
		for(User us : ur.findByName("Luigi Verdi")){
			System.out.println(us);
		}

	}

	public void insert(String name, int age, int addressId) {
		User u = new User(name, age);
		ur.save(u, addressId);
	}

	public void insertAddress(String road) {
		ar.save(road);
	}

	public void findAll() {
		for (int i = 0; i < ur.getAll().size(); i++) {

			System.out.println(ur.getAll().get(i));
			}
	}
	
	public void findById(int id) {
		System.out.println("L'utente con id "+ id + " è: " + ur.findById(id));
	}
	
	public void updateUser(User u, Object... objs ) {
		u.setName((String)objs[0]);
		u.setAge((int)objs[1]);
		
		ur.update(u);
	}
	
	public void deleteById(int id) {
		ur.deleteById(id);
	}
}
