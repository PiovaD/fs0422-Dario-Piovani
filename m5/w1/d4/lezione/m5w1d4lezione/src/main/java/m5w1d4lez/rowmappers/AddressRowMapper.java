package m5w1d4lez.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import m5w1d4lez.entities.Address;

public class AddressRowMapper implements RowMapper<Address>{

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		Address a = new Address(rs.getString("road"));
		a.setId(rs.getInt("id"));
		return a;
	}

	
}
