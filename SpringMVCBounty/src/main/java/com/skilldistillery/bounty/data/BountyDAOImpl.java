package com.skilldistillery.bounty.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	private final static String FIND_ALL_BY_FIRST_NAME = "SELECT b FROM Bounty b WHERE b.firstName like :fName";
	private final static String FIND_ALL_BY_LAST_NAME = "SELECT b FROM Bounty b WHERE b.lastName like :lName";
	private final static String FIND_ALL_BY_CRIME = "SELECT b FROM Bounty b WHERE crime = :crime";
	private final static String FIND_ALL_BY_PRICE_RANGE = "SELECT b FROM Bounty b WHERE b.price BETWEEN :min AND :max";
	private final static String FIND_ALL_BY_PRICE = "SELECT b FROM Bounty b WHERE b.price = :price";
	
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
	public Set<Bounty> findAllByKeywords(String text) {
		Set<Bounty> bounties = new HashSet<>();
		String[] keywords = text.trim().split("\\s+");
		for (String word : keywords) {
			bounties.addAll(findAllByFirstName(word));
			bounties.addAll(findAllByLastName(word));
			
			try {
				int price = Integer.parseInt(word);
				bounties.addAll(findAllByPrice(price));
				bounties.addAll(findAllByPriceRange(0, price));
			}
			catch(NumberFormatException nfe) {
				//skip finding all by Price/Range
			}
		}
		return bounties;
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
	public Bounty update(int id, Bounty b) {
		
		return null;
	}

	@Override
	public boolean delete(int id) {
		Bounty deletedBounty = em.find(Bounty.class, id);
		
		em.remove(deletedBounty);
		
		return em.contains(deletedBounty) ? false : true;
	
	}

	@Override
	public List<Bounty> findAllByFirstName(String fName) {
		String param = emptyOrNull(fName) ? "" : "%" + fName + "%";
		
		List<Bounty> bounties = em.createQuery(FIND_ALL_BY_FIRST_NAME, Bounty.class)
					.setParameter("fName", param)
					.getResultList();
	
		return bounties;
	}
	@Override
	public List<Bounty> findAllByLastName(String lName) {
		String param = emptyOrNull(lName) ? "" : "%" + lName + "%";
		
		List<Bounty> bounties = em.createQuery(FIND_ALL_BY_LAST_NAME, Bounty.class)
				.setParameter("lName", param)
				.getResultList();
		
		return bounties;
	}

	@Override
	public List<Bounty> findAllByCrime(Crime crime) {
		return em.createQuery(FIND_ALL_BY_CRIME, Bounty.class)
				.setParameter("crime", crime)
				.getResultList();
		
	}

	@Override
	public List<Bounty> findAllByPriceRange(int min, int max) {
		return em.createQuery(FIND_ALL_BY_PRICE_RANGE, Bounty.class)
				.setParameter("min", min)
				.setParameter("max", max)
				.getResultList();
	}
	
	

	@Override
	public List<Bounty> findAllByPrice(int price) {
		return em.createQuery(FIND_ALL_BY_PRICE, Bounty.class)
				.setParameter("price", price)
				.getResultList();
	}

	private boolean emptyOrNull(String s) {
		return s == null || s.isEmpty();
	}

	private boolean isLikeCrimeEnum(String s) {
		Crime.valueOf(s);
		return false;
	}
}
