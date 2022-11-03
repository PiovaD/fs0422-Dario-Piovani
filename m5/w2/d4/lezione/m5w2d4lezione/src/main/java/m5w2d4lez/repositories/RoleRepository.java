package m5w2d4lez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import m5w2d4lez.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
