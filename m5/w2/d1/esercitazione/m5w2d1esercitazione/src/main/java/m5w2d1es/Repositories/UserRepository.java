package m5w2d1es.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import m5w2d1es.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
