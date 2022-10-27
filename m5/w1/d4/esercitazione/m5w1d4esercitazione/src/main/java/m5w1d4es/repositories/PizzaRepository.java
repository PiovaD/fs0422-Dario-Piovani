package m5w1d4es.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import m5w1d4es.model.superclass.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer>{

}
