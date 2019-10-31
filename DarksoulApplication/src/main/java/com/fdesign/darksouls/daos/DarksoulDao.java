package com.fdesign.darksouls.daos;

import java.sql.ResultSet;
import java.util.List;

import com.fdesign.darksouls.models.Darksoul;
import com.fdesign.darksouls.models.User;

public interface DarksoulDao {
	
	DarksoulDao currentImplementation = new DarksoulDaoSQL();
	
	void releaseForm(String r, int f);
	
	void updateForm(int a, int b, int cc, int d, int ee, int g, String h, int i);
	
	int save(Darksoul d);
	
	List<Darksoul> findAll();
	
	List<Darksoul> findByName(String name);
	
	List<Darksoul> findByTypeId(int typeid);
	
	Darksoul findById(int id);

	void release(Darksoul r);

	int update(Darksoul up, Darksoul r);

}
