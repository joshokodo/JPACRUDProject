package com.skilldistillery.bounty.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.skilldistillery.bounty.entities.Bounty;

@Transactional
@Repository
public class BountyDAOImpl implements BountyDAO {

	private final static String ALL_BOUNTIES = "SELECT b FROM Bounty b";
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Bounty findById(int id) {
		return em.find(Bounty.class, id);
	}

	@Override
	public List<Bounty> findAll() {
		return em.createQuery(ALL_BOUNTIES, Bounty.class).getResultList();
	}

	@Override
	public Bounty add(Bounty b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bounty update(Bounty b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Bounty b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
