package deviceManagement.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import deviceManagement.Models.Device;
import deviceManagement.Models.DeviceType;
import deviceManagement.Models.User;
import deviceManagement.Repositories.DeviceRepository;
import deviceManagement.Repositories.UserRepository;

@Service
public class DeviceService {

	@Autowired
	DeviceRepository dr;

	@Autowired
	UserRepository ur;

	public List<Device> getAll() {
		return dr.findAll();
	}

	public Page<Device> getAllPaginate(Pageable p) {
		return dr.findAll(p);
	}

	public Optional<Device> getById(Long id) {
		return dr.findById(id);
	}
	
	public Optional<Device> getByType(DeviceType type) {
		return dr.findByType(type);
	}
	
	public Device assignDeviceToUser(Long idDevice, Long idUser) throws Exception {
        Optional<Device> deviceRes = dr.findById(idDevice);
        Optional<User> userRes = ur.findById(idUser);
        
        if (deviceRes.isPresent() && userRes.isPresent()) {
            Device deviceUp = deviceRes.get();
            User userUp = userRes.get();
            deviceUp.setUser(userUp);
            dr.save(deviceUp);
            return deviceUp;
        } else {
            throw new Exception("Device id or User id not found");
        }
    }

	public void save(Device d) {
		dr.save(d);
	}

	public void delete(Long id) throws Exception {
		Optional<Device> d = dr.findById(id);
		if(d.isPresent()) {
		dr.delete(d.get());
		} else {
			throw new Exception("Device non trovato");
		}
	}
}
