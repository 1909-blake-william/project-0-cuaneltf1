package com.fdesign.darksouls.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.fdesign.darksouls.models.Darksoul;
import com.fdesign.darksouls.models.DarksoulType;
import com.fdesign.darksouls.models.User;

public class DarksoulDaoSQL implements DarksoulDao {
	
	Darksoul extractDarksoul(ResultSet rs) throws SQLException {
		int id = rs.getInt("darksoul_id");
		String name = rs.getString("darksoul_name");
		int vitality = rs.getInt("vitality");
		int endurance = rs.getInt("endurance");
		int strength = rs.getInt("strength");
		int dexterity = rs.getInt("dexterity");
		int intelligence = rs.getInt("intelligence");
		int level = rs.getInt("darksoul_level");
		int soulbearerId = rs.getInt("SoulBearer");
		return new Darksoul(id, name, vitality, endurance, strength, dexterity, intelligence, level, new DarksoulType(soulbearerId, null),
				new User(soulbearerId, null, null, null));
	}

	@Override
	public int save(Darksoul d) {
		try (Connection c = com.fdesign.darksouls.util.ConnectionUtil.getConnection()) {
//			c.setAutoCommit(false);
			String sql = "INSERT INTO darksoul (darksoul_id, darksoul_name, vitality, endurance, strength, dexterity, intelligence, darksoul_level, darksoul_type_id, soulbearer) "
					+ " VALUES (darksoul_users_id_seq.nextval ,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, d.getName());
			ps.setInt(2, d.getVitality());
			ps.setInt(3, d.getEndurance());
			ps.setInt(4, d.getStrength());
			ps.setInt(5, d.getDexterity());
			ps.setInt(6, d.getIntelligence());
			ps.setInt(7, d.getLevel());
			ps.setInt(8, d.getType().getId());
			ps.setInt(9, d.getSoulBearer().getId());

			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}


	@Override
	public List<Darksoul> findAll() {
		try (Connection c = com.fdesign.darksouls.util.ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM darksoul";

			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<Darksoul> darksoul = new ArrayList<>();
			while (rs.next()) {
				darksoul.add(extractDarksoul(rs));
			}

			return darksoul;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public List<Darksoul> findByName(String name) {
		try (Connection c = com.fdesign.darksouls.util.ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM darksoul WHERE darksoul_name = ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();
			List<Darksoul> darksoul = new ArrayList<>();
			while (rs.next()) {
				darksoul.add(extractDarksoul(rs));
			}

			return darksoul;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Darksoul> findByTypeId(int typeid) {
		try (Connection c = com.fdesign.darksouls.util.ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM darksoul WHERE darksoul_type_id = ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, typeid);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return (List<Darksoul>) extractDarksoul(rs);
			} else {
				return null;
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Darksoul findById(int id) {
		try (Connection c = com.fdesign.darksouls.util.ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM darksoul WHERE darksoul_id = ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return extractDarksoul(rs);
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void release(Darksoul r) {
		try (Connection c = com.fdesign.darksouls.util.ConnectionUtil.getConnection()) {
//			c.setAutoCommit(false);
			String sql = "DELETE FROM darksoul WHERE darksoul_name = '?' AND SoulBearer = ? ";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, r.getName());
			ps.setInt(2, r.getSoulBearer().getId());
			ps.executeUpdate();
			return;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}

	@Override
	public int update(Darksoul up, Darksoul r) {
		try (Connection c = com.fdesign.darksouls.util.ConnectionUtil.getConnection()) {
			String sql = "Update darksoul set vitality = ?, endurance = ?, strength = ?, dexterity = ?, intelligence = ?, darksoul_level = ? WHERE darksoul_name = '?' AND soulbearer = ?";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, up.getVitality());
			ps.setInt(2, up.getEndurance());
			ps.setInt(3, up.getStrength());
			ps.setInt(4, up.getDexterity());
			ps.setInt(5, up.getIntelligence());
			ps.setInt(6, up.getLevel());
			ps.setString(7, r.getName());
			ps.setInt(8, r.getSoulBearer().getId());

			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

}
