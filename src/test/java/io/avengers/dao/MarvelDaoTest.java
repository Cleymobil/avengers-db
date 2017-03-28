package io.avengers.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.avengers.domain.Hero;

public class MarvelDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMarvelDao() {
		assertTrue(MarvelDao.c != null);
		
	}

	@Test
	public void testConnectToMySql() throws SQLException {
		String query = "SELECT * FROM heroes";

		// port 3306, no password
		Connection connect = new MarvelDao().connectToMySql();

		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
	
		connect.close();
		assertFalse(resultSet == null);
	}

}
