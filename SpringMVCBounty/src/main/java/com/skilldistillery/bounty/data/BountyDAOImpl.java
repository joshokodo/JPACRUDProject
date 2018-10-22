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
	private final static String FIND_ALL_BY_NICKNAME = "SELECT b FROM Bounty b WHERE b.nickname like :nickname";
	private final static String FIND_ALL_BY_DESCRIPTION = "SELECT b FROM Bounty b WHERE b.description like :description";
	private final static String FIND_ALL_BY_CRIME = "SELECT b FROM Bounty b WHERE crime = :crime";
	private final static String FIND_ALL_BY_PRICE_RANGE = "SELECT b FROM Bounty b WHERE b.price BETWEEN :min AND :max";
	private final static String FIND_ALL_BY_PRICE = "SELECT b FROM Bounty b WHERE b.price = :price";
	private final static String FIND_ALL_BY_WANTED = "SELECT b FROM Bounty b WHERE b.wantedAlive = :wanted";

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
	public List<Bounty> findAllByNames(String fName, String lName, String nickname) {
		StringBuilder query = new StringBuilder("SELECT b FROM Bounty b WHERE b.id > 0");
		if (!emptyOrNull(fName)) {
			query.append(" AND b.firstName LIKE '%" + fName + "%'");
		}
		if (!emptyOrNull(lName)) {
			query.append(" AND b.lastName LIKE '%" + lName + "%'");
		}
		if (!emptyOrNull(nickname)) {
			query.append(" AND b.nickname LIKE '%" + nickname + "%'");
		}

		List<Bounty> bounties = em.createQuery(query.toString(), Bounty.class).getResultList();
		return bounties;
	}

	@Override
	public Set<Bounty> findAllByKeywords(String text) {
		Set<Bounty> bounties = new HashSet<>();
		String[] keywords = text.trim().split("\\s+");
		for (String word : keywords) {
			bounties.addAll(findAllByFirstName(word));
			bounties.addAll(findAllByLastName(word));
			bounties.addAll(findAllByNickname(word));
			bounties.addAll(findAllByDescription(word));
			
			if(word.equalsIgnoreCase("DEAD")) {
				bounties.addAll(findAllByWanted('N'));
			}
			if(word.equalsIgnoreCase("ALIVE")) {
				bounties.addAll(findAllByWanted('Y'));
			}
			if(onlyLetters(word)) {
				bounties.addAll(findAllByCrime(word));
			}
			
			
			
			try {
				int price = Integer.parseInt(word);
				bounties.addAll(findAllByPrice(price));
				bounties.addAll(findAllByPriceRange(0, price));
			} catch (NumberFormatException nfe) {
				// skip finding all by Price/Range
			}
		}
		return bounties;
	}

	@Override
	public Bounty add(Bounty b) {
		em.persist(b);
		em.flush();
		if (b.getId() == 0) {
			em.getTransaction().rollback();
			return null;
		} else {
			return em.find(Bounty.class, b.getId());
		}
	}

	@Override
	public Bounty update(int id, Bounty b) {
		Bounty managedBounty = em.find(Bounty.class, id);
		managedBounty.setFirstName(b.getFirstName());
		managedBounty.setLastName(b.getLastName());
		managedBounty.setNickname(b.getNickname());
		managedBounty.setDescription(b.getDescription());
		managedBounty.setWantedAlive(b.getWantedAlive());
		managedBounty.setCrime(b.getCrime());
		managedBounty.setPrice(b.getPrice());
		
		
		return b;
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
	public List<Bounty> findAllByNickname(String nickname) {
		String param = emptyOrNull(nickname) ? "" : "%" + nickname + "%";

		List<Bounty> bounties = em.createQuery(FIND_ALL_BY_NICKNAME, Bounty.class)
				.setParameter("nickname", param)
				.getResultList();

		return bounties;
	}
	
	
	@Override
	public List<Bounty> findAllByDescription(String description) {
		String param = emptyOrNull(description) ? "" : "%" + description + "%";

		List<Bounty> bounties = em.createQuery(FIND_ALL_BY_DESCRIPTION, Bounty.class)
				.setParameter("description", param)
				.getResultList();

		return bounties;
	}

	@Override
	public List<Bounty> findAllByCrime(Crime crime) {
		return em.createQuery(FIND_ALL_BY_CRIME, Bounty.class)
				.setParameter("crime", crime)
				.getResultList();

	}
	
	public List<Bounty> findAllByCrime(String crime) {
		
		return findAllByCrime(isLikeCrimeEnum(crime));
		
		
		
	}

	@Override
	public List<Bounty> findAllByPriceRange(int min, int max) {
		return em.createQuery(FIND_ALL_BY_PRICE_RANGE, Bounty.class)
				.setParameter("min", min)
				.setParameter("max", max)
				.getResultList();
	}

	@Override
	public List<Bounty> findAllByWanted(char wanted) {
		return em.createQuery(FIND_ALL_BY_WANTED, Bounty.class)
				.setParameter("wanted", wanted)
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

	private Crime isLikeCrimeEnum(String s) {
		if("J-Walking".contains(s.toUpperCase()) || "J WALKING".contains(s.toUpperCase())) {
			return Crime.J_WALKING;
		}
		else if("PUBLIC INTOXICATION".contains(s.toUpperCase())) {
			return Crime.PUBLIC_INTOXICATION;
		}
		else if("PETTY THEFT".contains(s.toUpperCase())) {
			return Crime.PETTY_THEFT;
		}
		else if("DISORDERLY CONDUCT".contains(s.toUpperCase())) {
			return Crime.DISORDERLY_CONDUCT;
		}
		else if("VANDALISM".contains(s.toUpperCase())) {
			return Crime.VANDALISM;
		}
		else if("RECKLESS_DRIVING".contains(s.toUpperCase())) {
			return Crime.RECKLESS_DRIVING;
		}
		else if("TRESPASSING".contains(s.toUpperCase())) {
			return Crime.TRESPASS;
		}
		else {
			return null;
		}
	}

	public boolean onlyLetters(String s) {
		char[] letters = s.toCharArray();
		for (char c : letters) {
			if(!Character.isAlphabetic(c)) {
				return false;
			}
		}
		return true;
	}

}
