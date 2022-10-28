package gestionePrenotazioni.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gestionePrenotazioni.models.Workstation;
import gestionePrenotazioni.models.WorkstationType;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, Long> {

	@Query("SELECT w FROM Workstation w WHERE w.building.city =:city AND w.type =:type")
	public List<Workstation> findByCityAndType(@Param("city") String city, @Param("type") WorkstationType type);
}
