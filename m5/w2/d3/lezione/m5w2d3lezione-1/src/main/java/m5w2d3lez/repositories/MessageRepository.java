package m5w2d3lez.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import m5w2d3lez.entities.Message;

@Repository
public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {
	@Query(nativeQuery = true, value = "SELECT * FROM message WHERE lower(title) LIKE %:n% OR WHERE lower(content) LIKE %:n%")
	public Page<Message> findByMessageAndPaginate(@Param("n") String n, Pageable p);

	@Query(value = "SELECT m FROM Message m WHERE m.author.username LIKE lower(concat('%', :n, '%'))")
	public Page<Message> findByAuthorAndPaginate(@Param("n") String n, Pageable p);
}
