package m5w2d4lez;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class M5w2d4lezioneApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(M5w2d4lezioneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("OK");
		
	}

}
