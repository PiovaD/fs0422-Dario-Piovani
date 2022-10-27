package m5w1d4lez3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import m5w1d4lez3.config.ConfigCar;
import m5w1d4lez3.entities.Car;
import m5w1d4lez3.entities.Engine;
import m5w1d4lez3.entities.EngineType;
import m5w1d4lez3.entities.Owner;
import m5w1d4lez3.services.CarService;

@SpringBootApplication
public class M5w1d4lezione3Application implements CommandLineRunner{
	
	@Autowired
	CarService cs;
	
	public static void main(String[] args) {
		SpringApplication.run(M5w1d4lezione3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		configCodedIstances();
		
		System.out.println(getAllCar());
		
		//deleteCar(2);
		
	}
	
	public void strongCodedIstances() {

		saveCar(new Car("Yaris", 20_000, new Engine("ECV-T", EngineType.HYBRID), new Owner("Franco")));

		saveCar(new Car("Panda", 10_000, new Engine("Baracca", EngineType.PETROL), new Owner("Carla")));

		saveCar(new Car("Model s", 100_000, new Engine("Pawa", EngineType.ELECTRIC), new Owner("Mario")));
		
	}

	public List<Car> getAllCar(){
		return cs.getAll();
	}
	
	public void saveCar(Car c) {
		cs.addCar(c);
	}
	
	public void deleteCar(int id) {
		cs.deleteById(id);
	}
	
	public void configCodedIstances() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigCar.class);
		
		saveCar(ctx.getBean("getPetrolCar", Car.class));

		saveCar(ctx.getBean("getElectricCar", Car.class));

		saveCar(ctx.getBean("getHybridCar", Car.class));
		
		ctx.close();
	}
}
