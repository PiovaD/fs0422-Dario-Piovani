package m5w1d4lez.repositories;

import java.util.List;

import m5w1d4lez.entities.Address;

public interface IAddressRepository {

	public int save(String road);

	public int update(Address address);

	public int deleteById(int id);

	public List<Address> getAll();

	public Address findById(int id);
}
