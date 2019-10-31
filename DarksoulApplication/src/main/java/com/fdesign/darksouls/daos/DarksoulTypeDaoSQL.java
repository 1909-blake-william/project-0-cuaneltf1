package com.fdesign.darksouls.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fdesign.darksouls.models.DarksoulType;

public class DarksoulTypeDaoSQL implements DarksoulTypeDao {
	
	List<DarksoulType> extractTypes(ResultSet rs) throws SQLException {
		List<DarksoulType> types = new ArrayList<>();

		while (rs.next()) {
			String name = rs.getString("name");
			int id = rs.getInt("darksoul_types_id");
			types.add(new DarksoulType(id, name));
		}

		return types;
	}

	@Override
	public int save(DarksoulType darksoulType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DarksoulType> findAll() {
		try (Connection c = com.fdesign.darksouls.util.ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM darksoul_types";

			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			return extractTypes(rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public DarksoulType findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DarksoulType findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
