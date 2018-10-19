package com.skilldistillery.bounty.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.skilldistillery.bounty.entities.Bounty;
import com.skilldistillery.bounty.entities.Crime;

@Transactional
@Repository
public class BountyDAOImpl implements BountyDAO {

	private final static String ALL_BOUNTIES = "SELECT b FROM Bounty b";
	private final static String FIND_BOUNTY_BY_FIRSTNAME = "SELECT b FROM Bounty b WHERE b.firstName like ?";
	private final static String FIND_BOUNTY_BY_LASTNAME = "SELECT b FROM Bounty b WHERE b.lastName like ?";
	private final static String FIND_ALL_BY_CRIME = "SELECT b FROM Bounty b WHERE crime = ?";
	private final static String FIND_ALL_BY_PRICE_RANGE = "SELECT b FROM Bounty b WHERE b.price BETWEEN ? AND ?";
	
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
		em.persist(b);
		em.flush();
		if(b.getId() == 0) {
			em.getTransaction().rollback();
			return null;
		}
		else {
			return em.find(Bounty.class, b.getId());
		}
	}

	@Override
	public Bounty update(Bounty b) {
		Bounty managedBounty = em.find(Bounty.class, b.getId());
		
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		Bounty deletedBounty = em.find(Bounty.class, id);
		
		em.remove(deletedBounty);
		
		return em.contains(deletedBounty) ? false : true;
	
	}

	@Override
	public List<Bounty> findAllByName(String name) {
		List<Bounty> bounties = em.createQuery(FIND_BOUNTY_BY_FIRSTNAME, Bounty.class)
				.setParameter(1, "'%" + name + "%'")
				.getResultList();
		
		if(bounties == null) {
			bounties = em.createQuery(FIND_BOUNTY_BY_LASTNAME, Bounty.class)
					.setParameter(1, "'%" + name + "%'")
					.getResultList(); 
		}
		else {
			bounties.addAll(em.createQuery(FIND_BOUNTY_BY_LASTNAME, Bounty.class)
					.setParameter(1, "'%" + name + "%'")
					.getResultList());
		}
		return bounties;
	}

	@Override
	public List<Bounty> findAllByCrime(Crime crime) {
		return em.createQuery(FIND_ALL_BY_CRIME, Bounty.class)
				.setParameter(1, "'" + crime + "'")
				.getResultList();
		
	}

	@Override
	public List<Bounty> findAllByPriceRange(int min, int max) {
		return em.createQuery(FIND_ALL_BY_PRICE_RANGE, Bounty.class)
				.setParameter(1, min)
				.setParameter(2, max)
				.getResultList();
	}

	
}
