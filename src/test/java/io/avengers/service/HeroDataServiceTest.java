package io.avengers.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import io.avengers.domain.Hero;
import io.avengers.reset.ResetApplication;

import java.sql.Connection;
import java.sql.SQLException;

public class HeroDataServiceTest {
	HeroDataService heroDataService;

	@BeforeClass
	public static void deleteDataBase() throws Exception {
		ResetApplication.main(new String[]{});
	}

	
	@Before
	public void setUp() throws Exception {
		heroDataService = new HeroDataService();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindHeroData() throws SQLException {
		assertTrue(heroDataService.findHeroData("Hulk").getIrl().equals("Bruce Banner"));
		assertTrue(heroDataService.findHeroData("Wolverine").getTeam().equals("X-men"));

	}

}
