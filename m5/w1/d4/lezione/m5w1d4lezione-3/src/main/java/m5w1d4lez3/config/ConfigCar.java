package m5w1d4lez3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import m5w1d4lez3.entities.Car;
import m5w1d4lez3.entities.Engine;
import m5w1d4lez3.entities.EngineType;
import m5w1d4lez3.entities.Owner;

@Configuration
public class ConfigCar {
	
	@Bean
	@Scope("prototype")
	public Car getHybridCar() {
		return new Car("Yaris", 20_000, getEngine1(),getOwner1());
	}

	@Bean
	@Scope("prototype")
	public Car getElectricCar() {
		return new Car("Model s", 100_000, getEngine2(),getOwner1());
	}

	@Bean
	@Scope("prototype")
	public Car getPetrolCar() {
		return new Car("Panda", 10_000, getEngine3(), getOwner1());
	}	

	@Bean
	@Scope("prototype")
	public Owner getOwner1() {
		return new Owner("Franco");
	}
	
	@Bean
	@Scope("prototype")
	public Owner getOwner2() {
		return new Owner("Mario");
	}
	
	@Bean
	@Scope("prototype")
	public Owner getOwner3() {
		return new Owner("Carla");
	}
	
	@Bean
	@Scope("prototype")
	public Engine getEngine1() {
		return new Engine("ECV-T", EngineType.HYBRID);
	}
	
	@Bean
	@Scope("prototype")
	public Engine getEngine2() {
		return new Engine("Pawa", EngineType.ELECTRIC);
	}
	
	@Bean
	@Scope("prototype")
	public Engine getEngine3() {
		return new Engine("Baracca", EngineType.PETROL);
	}
}
