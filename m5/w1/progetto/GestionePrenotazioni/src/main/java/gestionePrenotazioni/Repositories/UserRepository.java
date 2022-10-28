package gestionePrenotazioni.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestionePrenotazioni.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
