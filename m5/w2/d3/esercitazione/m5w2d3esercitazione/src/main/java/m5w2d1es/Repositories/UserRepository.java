package m5w2d1es.Repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import m5w2d1es.models.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
