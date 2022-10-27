package m5w1d4lez.repositories;

import java.util.List;

import m5w1d4lez.entities.User;

public interface IUserRepositories {

	public int count();

	public int save(User user, int addressId);

	public int update(User user);

	public int deleteById(int id);

	public List<User> getAll();

	public User findById(int id);

	public List<User> findByName(String name);
}
