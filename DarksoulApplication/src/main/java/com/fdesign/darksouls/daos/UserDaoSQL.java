package com.fdesign.darksouls.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fdesign.darksouls.models.User;

public class UserDaoSQL implements UserDao {
	
	User extractUser(ResultSet rs) throws SQLException {
		int id = rs.getInt("user_id");
		String rsUsername = rs.getString("username");
		String rsPassword = rs.getString("password");
		String role = rs.getString("role");
		return new User(id, rsUsername, rsPassword, role);
	}

	@Override
	public int save(User u) {
		try (Connection c = com.fdesign.darksouls.util.ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO darksoul_users (user_id, username, password) "
					+ " VALUES (darksoul_users_id_seq.nextval ,?,?)";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());

			return ps.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return 0;
		}
	}


	@Override
	public List<User> findAll() {
		try (Connection c = com.fdesign.darksouls.util.ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM darksoul_users";

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<User> users = new ArrayList<User>();
			while (rs.next()) {
				users.add(extractUser(rs));
			}

			return users;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return null;
		}
	}


	@Override
	public User findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		try (Connection c = com.fdesign.darksouls.util.ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM darksoul_users " + "WHERE username = ? AND password = ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return extractUser(rs);
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return null;
		}
	}


	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
