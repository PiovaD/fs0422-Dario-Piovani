package m5w1d4lez.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import m5w1d4lez.entities.Address;

@Repository
public class JdbcAddressRepository implements IAddressRepository{	

	@Autowired
	private JdbcTemplate t;

	@Override
	public int save(String road) {
		return t.update("INSERT INTO addresses (road) VALUES (?)", road);
	}

	@Override
	public int update(Address address) {
		return 0;
	}

	@Override
	public int deleteById(int id) {
		return 0;
	}

	@Override
	public List<Address> getAll() {
		return null;
	}

	@Override
	public Address findById(int id) {
		return null;
	}

}
