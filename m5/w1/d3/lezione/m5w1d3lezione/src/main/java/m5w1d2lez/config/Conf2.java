package m5w1d2lez.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import m5w1d2lez.beans.AnimalInfo;
import m5w1d2lez.beans.Dog;

@Configuration
@PropertySource("classpath:application.properties")
public class Conf2 {

	@Bean
	public Dog dog1() {
		Dog d = new Dog();
		//d.setAnimalInfo(dog1AI());
		d.setName("Artu");
		return d;
	}
	
	@Bean
	@Primary
	public AnimalInfo dog1AI() {
		return new AnimalInfo("Golden Retriever", 1000);
	}
	
	@Bean
	public AnimalInfo dog1AI2() {
		return new AnimalInfo("Chiwawa", 1);
	}
	
	@Bean
	public Dog dog2() {
		return null;
	}
}
