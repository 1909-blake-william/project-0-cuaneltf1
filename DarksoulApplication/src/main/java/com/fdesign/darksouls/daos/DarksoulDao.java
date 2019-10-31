package com.fdesign.darksouls.daos;

import java.sql.ResultSet;
import java.util.List;

import com.fdesign.darksouls.models.Darksoul;

public interface DarksoulDao {
	
	DarksoulDao currentImplementation = new DarksoulDaoSQL();
	
	int save(Darksoul d);
	
	List<Darksoul> findAll();
	
	List<Darksoul> findByName(String name);
	
	List<Darksoul> findByTypeId(int typeid);
	
	Darksoul findById(int id);

	void release(Darksoul r);

	int update(Darksoul up, Darksoul r);
}
