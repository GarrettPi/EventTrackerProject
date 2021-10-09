package com.skilldistillery.printtracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SourceTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Source source;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPA3dPrintTracker");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		source = em.find(Source.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		source = null;
	}

	@Test
	void test_print_entity_mappings() {
		assertNotNull(source);
		assertEquals("Me", source.getName());
	}

}
