package m5w1d4lez.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import m5w1d4lez.entities.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User u = new User(rs.getString("name") ,rs.getInt("age"), new AddressRowMapper().mapRow(rs, rowNum));
		u.setId(rs.getInt("id"));
		return u;
	}

}
