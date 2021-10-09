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

class MaterialTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Material material;
	
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
		material = em.find(Material.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		material = null;
	}

	@Test
	void test_print_entity_mappings() {
		assertNotNull(material);
		assertEquals("Inland 1.75mm", material.getName());
	}

}
