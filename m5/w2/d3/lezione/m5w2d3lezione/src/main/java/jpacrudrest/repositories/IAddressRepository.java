package jpacrudrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jpacrudrest.entities.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {

}
