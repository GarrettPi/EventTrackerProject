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

class PrinterTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Printer printer;
	
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
		printer = em.find(Printer.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		printer = null;
	}

	@Test
	@DisplayName("test printer entity mappings")
	void test_printer_entity_mappings() {
		assertNotNull(printer);
		assertEquals("CR10s Pro V2", printer.getName());
	}
	
	@Test
	@DisplayName("test relational mappings on Printer")
	void test_relational_mappings() {
		assertNotNull(printer);
		assertEquals("FDM", printer.getPrinterType().getName());
	}

}
