package com.skilldistillery.bounty.data;

import java.util.List;
import java.util.Set;

import com.skilldistillery.bounty.entities.Bounty;
import com.skilldistillery.bounty.entities.Crime;

public interface BountyDAO {
	Bounty findById(int id);
	List<Bounty> findAllByFirstName(String fName);
	List<Bounty> findAllByLastName(String lName);
	List<Bounty> findAllByNickname(String nickname);
	List<Bounty> findAllByDescription(String description);
	List<Bounty> findAllByCrime(Crime crime);
	List<Bounty> findAllByCrime(String crime);
	List<Bounty> findAllByPriceRange(int min, int max);
	List<Bounty> findAllByPrice(int price);
	List<Bounty> findAllByWanted(char wanted);
	List<Bounty> findAll();
	List<Bounty> findAllByNames(String fName, String lName, String nickname);
	Set<Bounty> findAllByKeywords(String text);
	Bounty add(Bounty b);
	Bounty update(int id, Bounty b);
	boolean delete(int id);
	
}
