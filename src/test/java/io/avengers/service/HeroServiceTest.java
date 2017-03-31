package io.avengers.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import io.avengers.dao.TeamDao;
import io.avengers.domain.Hero;
import io.avengers.domain.Sex;
import io.avengers.domain.Team;
import io.avengers.reset.ResetApplication;

import java.sql.Connection;
import java.sql.SQLException;


public class HeroServiceTest {
	

	HeroService heroService;

	@BeforeClass
	public static void deleteDataBase() throws Exception {
		ResetApplication.main(new String[]{});
	}

	
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
	
	@Test
	public void testFindHeroesByName(){
		assertTrue(heroService.findHeroesByName("Spider").size()==1);
		assertTrue((heroService.findHeroesByName("Spider").iterator().next()).getName().contains("i"));
		
	}
	@Test
	public void testFindHeroesById() throws SQLException{
		assertTrue(heroService.findHeroesById(1).getName().equals("Spiderman"));
		assertFalse(heroService.findHeroesById(1).getName().equals("Hulk"));
	}
	//TODO
	
	@Test
	public void testCreateModifyDeleteHero() throws SQLException {
	
		Long likes = (long) 987;
		Long dislikes = (long) 98;
		
		Hero testHero = new Hero("tonton2" , likes , dislikes);
		
		
		testHero=heroService.createHero(testHero);
		assertTrue(testHero.getId()>0);
		System.out.println(testHero.getName());
		//int heroid=heroService.createHero(testHero).getId();
		//testHero=(heroService.findHeroesById(testHero.getId()));
		//assertTrue(testHero.getId()==heroid);
		System.out.println(testHero.getId());
		//System.out.println(testHero);
		
		//assertNotNull(testHero.getTeamId());
		//System.out.println(heroService.findHeroesById(heroid));
		//heroService.removeTeamFromHero(test);
		//assertNull(test.getTeamId());
		//System.out.println(heroService.findHeroesById(heroid));
		/*
		heroService.changeHeroName(heroid, "Manolo1");
		assertTrue(test.getName().equals("Manolo1"));
		
		heroService.changeHeroName(heroid, "tonton2");
		
		assertTrue(heroService.findHeroesByName("tonton2").isEmpty());
		*/
		//heroService.deleteHero(testHero);
		
		
		
		
	}
	
	
	
}
