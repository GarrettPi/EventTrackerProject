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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrintTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Print print;
	
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
		print = em.find(Print.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		print = null;
	}

	@Test
	@DisplayName("test print entity mappings")
	void test_print_entity_mappings() {
		assertNotNull(print);
		assertEquals("Tricorder", print.getName());
		assertEquals(240, print.getDuration());
		assertEquals(0.15, print.getMaterialConsumed());
	}
	
	@Test
	@DisplayName("test relationship mappings on print")
	void test_relation_mappings() {
		assertNotNull(print);
		assertEquals("Tricorder", print.getName());
		assertEquals("CR10s Pro V2", print.getPrinter().getName());
		assertEquals("Me", print.getSource().getName());
		assertEquals("Inland 1.75mm", print.getMaterial().getName());
		
	}

}
