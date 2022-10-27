package m5w1d4es.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import m5w1d4es.model.Souvenir;

@Repository
public interface SouvenirRepository extends JpaRepository<Souvenir, Integer>{

}
