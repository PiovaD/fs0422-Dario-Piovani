package m5w2d1es.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import m5w2d1es.models.Building;

@Repository
public interface BuildingRepository extends PagingAndSortingRepository<Building, Long> {

	Page<Building> findByCitta(String citta, Pageable pageable);

	Page<Building> findByNome(String name, Pageable pageable);

	Page<Building> findBySecurityCode(String securityCode, Pageable pageable);

}
