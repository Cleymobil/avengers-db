package io.avengers.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import io.avengers.domain.Hero;
import io.avengers.domain.Team;
import io.avengers.reset.ResetApplication;

public class TeamDaoTest {

	TeamDao dao;
	HeroDao heroDao;
	Connection connect;

	@BeforeClass
	public static void deleteDataBase() throws Exception {
		ResetApplication.main(new String[]{});
	}
	
	@Before
	public void setUp() throws Exception {
		dao = new TeamDao();
		heroDao=new HeroDao();
		connect = dao.connectToMySql();
	}

	@After
	public void tearDown() throws Exception {
		connect.close();
	}

	@Test
	public void testFindAll() throws SQLException {
		assertTrue(dao.findAll().size() != 0);
	}
	
	@Test
	public void testFindTeamById() throws Exception {

		assertTrue(dao.findTeamById(1) != null);
		



	}
	@Test
	public void testFindTeamByName() throws Exception {

		assertTrue(dao.findTeamByName("Avengers")!=null);
		//assertFalse(dao.findTeamByName("fneufbeyzigreqgreg")==null);
		
		Team avengers = dao.findTeamByName("Avengers");
		
		assertTrue(dao.findTeamByName("Avengers").equals(avengers));
		assertFalse(dao.findTeamByName("toto").equals(avengers));

		

	}
	@Test
	public void testFindTeamsByName() throws Exception {

		assertTrue(dao.findTeamsByName("Avengers").size()!=0);
		assertTrue(dao.findTeamsByName("fneufbeyzigreqgreg").size()==0);
		
		Team avengers = dao.findTeamByName("Avengers");
		

		
		boolean found = false;
		for (Team t : dao.findTeamsByName("Av")) {
			if (t.equals(avengers)) {
				found = true;
			}
		}
		assertTrue(found);
		
		
	
	}
	
	@Test
	public void testFindTeamHeroes() throws Exception {

		assertTrue(dao.findTeamHeroes(1).size()!=0);
		assertTrue(dao.findTeamHeroes(15886523).size()==0);
		
		/*
		Hero mockedHero = new Hero();
		mockedHero.setName("Toto");
		
		HeroDao mock = Mockito.mock(HeroDao.class);
		Mockito.when(mock.findHeroesByName("Toto").iterator().next()).thenReturn(mockedHero);
		Hero toto = mock.findHeroesByName("Toto").iterator().next();
		
		assertTrue(toto.getName().equals(mockedHero.getName()));
		*/
		
		Hero hulk = heroDao.findHeroesByName("Hulk").iterator().next();
		boolean found = false;
		for (Hero h : dao.findTeamHeroes(1)) {
			if (h.equals(hulk)) {
				found = true;
			}
		}
		assertTrue(found);
			
	}
	
	@Test
	public void testCreateTeam()throws Exception {
		
		dao.createTeam("tototeam","Team of toto guys");
		assertTrue(dao.findTeamsByName("tototeam").size()!=0);
		
		//Integer Id = dao.findTeamByName("tototeam").getId();
		
		//dao.deleteTeam(Id);
		//assertTrue(dao.findTeamsByName("tototeam").size()==0);
		
		
		
		
		
		
		
		
	}
	
	

}
