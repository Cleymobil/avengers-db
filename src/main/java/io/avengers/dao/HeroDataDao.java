package io.avengers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import io.avengers.domain.Hero;
import io.avengers.domain.Sex;

public class HeroDataDao extends MarvelDao{

	public Hero findHeroData(String term) throws SQLException {

		String query = "SELECT h.id, h.name, h.sex, h.likes, h.dislikes, h.picture, h.abilities, h.history, irl.name as irl, t.name as team FROM heroes h INNER JOIN irl ON h.id=irl.hero_id LEFT JOIN team_hero th ON h.id=th.hero_id  LEFT JOIN team t ON t.id=th.team_id WHERE h.name LIKE ?";

		// port 3306, no password
		Connection connect = connectToMySql();

		PreparedStatement statement = connect.prepareStatement(query);
		statement.setString(1,'%'+term+'%');
	
		ResultSet resultSet = statement.executeQuery();

		Hero h = new Hero();
		while (resultSet.next()) {

			try {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
			
				String sSex = resultSet.getString("sex");
				Long likes = resultSet.getLong("likes");
				Long dislikes = resultSet.getLong("dislikes");
				byte[] picture = resultSet.getBytes("picture");
				String abilities = resultSet.getString("abilities");
				String history = resultSet.getString("history");
				String team = resultSet.getString("team");
				String irl = resultSet.getString("irl");
				

				Hero h1 = new Hero(id, name, Sex.O, likes, dislikes, picture, abilities, history);
				h1.setIrl(irl);
				h1.setTeam(team);
				h = h1;

			} catch (Exception e) {
				throw new IllegalStateException("Database has been compromised: " + e.getMessage());
			}
		}
		
		
		
		
		
		connect.close();
		return h;

	}

}
