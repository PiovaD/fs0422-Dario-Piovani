package m5w1d4lez3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m5w1d4lez3.entities.Car;
import m5w1d4lez3.repositories.ICarRepository;

@Service
public class CarService {
	
	@Autowired
	ICarRepository cr;
	
	public void addCar(Car c) {
		cr.save(c);
	}
	
	public List<Car> getAll(){
		return cr.findAll();
	}
	
	public void deleteById(int id) {
		cr.deleteById(id);
	}
}
