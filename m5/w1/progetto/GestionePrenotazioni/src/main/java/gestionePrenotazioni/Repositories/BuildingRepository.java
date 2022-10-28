package gestionePrenotazioni.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestionePrenotazioni.models.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

}
