package m5w1d4lez.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import m5w1d4lez.entities.User;
import m5w1d4lez.rowmappers.UserRowMapper;

@Repository
public class JdbcUserRepository implements IUserRepositories {

	@Autowired
	private JdbcTemplate t;

	@Override
	public int count() {
		return t.queryForObject("SELECT COUNT(*) FROM users", Integer.class);
	}

	@Override
	public int save(User user, int addressId) {
		return t.update("INSERT INTO users (name, age, address_id) VALUES (?,?,?)", user.getName(), user.getAge(),
				addressId);
	}

	@Override
	public int update(User user) {
		return t.update("UPDATE users SET name = ?, age = ?, address_id = ? WHERE id = ?",
				user.getName(), user.getAge(), user.getAddress().getId(),user.getId());
	}

	@Override
	public int deleteById(int id) {
		return t.update("DELETE FROM users WHERE id = ?", id);
	}

	@Override
	public List<User> getAll() {
		return t.query("SELECT * FROM users JOIN addresses ON users.address_id = addresses.id", new UserRowMapper());
	}

	@Override
	public User findById(int id) {
		try {

			return t.queryForObject(
					"SELECT * FROM users JOIN addresses ON users.address_id = addresses.id WHERE users.id = ?",
					new UserRowMapper(), id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<User> findByName(String name) {
		return t.query("SELECT * FROM users JOIN addresses ON users.address_id = addresses.id WHERE users.name = ?",
				new UserRowMapper(), name);
	}

}
