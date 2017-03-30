package io.avengers.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class HeroServiceTest {

	HeroService heroService;

	
	
	@Before
	public void setUp() throws Exception {
		heroService= new HeroService();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAll() {
		assertTrue(heroService.findAll().size()>1);
		assertFalse(heroService.findAll().size()<0);
	}
	@ignore
	@Test
	public void testFindHeroesByName(){
		asserTrue(heroService.findHeroesByName("Spider").iterator().next());
		assertFalse(heroService.findAll().size()<0);
	}

}
