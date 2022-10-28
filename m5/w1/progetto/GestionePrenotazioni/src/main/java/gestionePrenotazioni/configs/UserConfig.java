package gestionePrenotazioni.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import gestionePrenotazioni.models.User;

@Configuration
public class UserConfig {

	@Bean(name = "u1")
	@Scope("singleton")
	public User newUser1() {
		return new User("user1", "Dante", "dante@gmail.com");
	}
	
	@Bean(name = "u2")
	@Scope("singleton")
	public User newUser2() {
		return new User("user2", "Virgilio", "virgilio@gmail.com");
	}
}
