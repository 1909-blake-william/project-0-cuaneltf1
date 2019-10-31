package com.fdesign.darksouls.daos;

import java.util.List;

import com.fdesign.darksouls.models.DarksoulType;

public interface DarksoulTypeDao {
	
	DarksoulTypeDao currentImplementation = new DarksoulTypeDaoSQL();
	
	int save(DarksoulType darksoulType);
	
	List<DarksoulType> findAll();
	
	DarksoulType findById();
	
	DarksoulType findByName(String name);
}
