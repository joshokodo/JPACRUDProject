package com.skilldistillery.bounty.data;

import java.util.List;

import com.skilldistillery.bounty.entities.Bounty;
import com.skilldistillery.bounty.entities.Crime;

public interface BountyDAO {
	Bounty findById(int id);
	List<Bounty> findAllByName(String name);
	List<Bounty> findAllByCrime(Crime crime);
	List<Bounty> findAllByPriceRange(int min, int max);
	List<Bounty> findAll();
	Bounty add(Bounty b);
	Bounty update(Bounty b);
	boolean deleteById(int id);
	
}
