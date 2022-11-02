package jpacrudrest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpacrudrest.entities.Address;
import jpacrudrest.repositories.IAddressRepository;

@Service
public class AddressService {

	@Autowired
	IAddressRepository ar;
	
	
	public Optional<Address> getById(int id) {
		return ar.findById(id);
	}
}
