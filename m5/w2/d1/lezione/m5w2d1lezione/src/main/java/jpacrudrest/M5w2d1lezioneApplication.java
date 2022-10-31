package jpacrudrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jpacrudrest.services.UserService;

@SpringBootApplication
public class M5w2d1lezioneApplication implements CommandLineRunner{

	@Autowired
	UserService us;
	
	public static void main(String[] args) {
		SpringApplication.run(M5w2d1lezioneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
