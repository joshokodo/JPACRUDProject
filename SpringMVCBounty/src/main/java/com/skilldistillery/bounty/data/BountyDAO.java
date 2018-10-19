package com.skilldistillery.bounty.data;

import java.util.List;

import com.skilldistillery.bounty.entities.Bounty;

public interface BountyDAO {
	Bounty findById(int id);
	List<Bounty> findAll();
	Bounty add(Bounty b);
	Bounty update(Bounty b);
	boolean delete(Bounty b);
	boolean deleteById(int id);
	
}
