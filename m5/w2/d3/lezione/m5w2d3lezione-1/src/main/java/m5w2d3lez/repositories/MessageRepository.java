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
	
	@Query(value ="SELECT m FROM messages m WHERE m.sender.username LIKE lower(concat('%', :n, '%'))")
	public Page<Message> findByAuthorAndPaginate(@Param("n") String n, Pageable p);
	
	@Query(nativeQuery = true, value = "SELECT * FROM messages WHERE lower(title) LIKE %:n% OR lower(content) LIKE %:n%")
	public Page<Message> findByMessageAndPaginate(@Param("n") String n, Pageable p);


}
