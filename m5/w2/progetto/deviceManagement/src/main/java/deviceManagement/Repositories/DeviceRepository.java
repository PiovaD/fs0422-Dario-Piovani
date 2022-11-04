package deviceManagement.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import deviceManagement.Models.Device;
import deviceManagement.Models.DeviceType;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

	@Query(value = "SELECT d FROM Device d WHERE deviceType LIKE :t ")
	public Optional<Device> findByType(@Param("t") DeviceType type);

}
