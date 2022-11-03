package m5w2d4lez.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import m5w2d4lez.entities.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer>{

	@Query(value = "SELECT u FROM User u WHERE username LIKE concat('%', :u , '%')")
	Optional<User> findByUsername(@Param("u") String username);
}
