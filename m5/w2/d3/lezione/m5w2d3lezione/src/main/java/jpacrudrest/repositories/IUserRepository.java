package jpacrudrest.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jpacrudrest.entities.User;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Integer> {

	@Query(
			nativeQuery = true,
			value = "SELECT * FROM users WHERE name = :n"
	)
	public List<User> getByName(@Param("n") String n);
	
	@Query(nativeQuery = true, value = "SELECT * FROM users WHERE lower(name) LIKE %:n%")
	public Page<User>findByNameAndPaginate(@Param("n") String n, Pageable p);
}
