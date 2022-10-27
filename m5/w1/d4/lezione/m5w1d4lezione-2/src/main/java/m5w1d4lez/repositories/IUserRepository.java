package m5w1d4lez.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import m5w1d4lez.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM users WHERE name = :n"
	)
	public List<User> getByName(@Param("n") String n);
}
