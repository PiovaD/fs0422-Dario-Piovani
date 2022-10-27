package m5w1d4lez3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import m5w1d4lez3.entities.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car, Integer>{

}
