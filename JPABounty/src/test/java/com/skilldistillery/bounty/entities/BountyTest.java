package com.skilldistillery.bounty.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BountyTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Bounty actual;

	@BeforeAll
	static void setUpEmf() {
		emf = Persistence.createEntityManagerFactory("Bounty");
	}

	@AfterAll
	static void tearDownEmf() {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		actual = em.find(Bounty.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		actual = null;
	}

	@Test
	@DisplayName("tests that entity was properly mapped for all data")
	void test_bounty_mapping() {
		Bounty expected = new Bounty("Luffy", "Monkey", 1_500_000_000, 'N', "short, black hair, wears strawhat",
				Crime.J_WALKING, null);
		
		assertEquals(expected.getFirstName(), actual.getFirstName());
		assertEquals(expected.getLastName(), actual.getLastName());
		assertEquals(expected.getWantedAlive(), actual.getWantedAlive());
		assertEquals(expected.getPrice(), actual.getPrice());
		assertEquals(expected.getCrime(), actual.getCrime());
		assertEquals(expected.getDescription(), actual.getDescription());
		assertEquals(expected.getNickname(), actual.getNickname());
	}

}
