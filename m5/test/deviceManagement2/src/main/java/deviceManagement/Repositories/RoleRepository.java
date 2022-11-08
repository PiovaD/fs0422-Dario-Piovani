package deviceManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import deviceManagement.Models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
