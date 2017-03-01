package io.avengers.domain;

import java.util.Arrays;

public class Hero {

	int id;
	String name;
	Sex sex;
	long likes;
	long dislikes;
	byte[] picture;
	String abilities;
	String history;
	String team;
	String irl;

	public Hero() {

	}

	public Hero(int id, String name, Sex sex, long likes, long dislikes, byte[] picture, String abilities,
			String history) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.likes = likes;
		this.dislikes = dislikes;
		this.picture = picture;
		this.abilities = abilities;
		this.history = history;
		this.team = null;
		this.irl = null;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getAbilities() {
		return abilities;
	}

	public void setAbilities(String abilities) {
		this.abilities = abilities;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getIrl() {
		return irl;
	}

	public void setIrl(String irl) {
		this.irl = irl;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public long getLikes() {
		return likes;
	}

	public void setLikes(long likes) {
		this.likes = likes;
	}

	public long getDislikes() {
		return dislikes;
	}

	public void setDislikes(long dislikes) {
		this.dislikes = dislikes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abilities == null) ? 0 : abilities.hashCode());
		result = prime * result + (int) (dislikes ^ (dislikes >>> 32));
		result = prime * result + ((history == null) ? 0 : history.hashCode());
		result = prime * result + id;
		result = prime * result + ((irl == null) ? 0 : irl.hashCode());
		result = prime * result + (int) (likes ^ (likes >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(picture);
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hero other = (Hero) obj;
		if (abilities == null) {
			if (other.abilities != null)
				return false;
		} else if (!abilities.equals(other.abilities))
			return false;
		if (dislikes != other.dislikes)
			return false;
		if (history == null) {
			if (other.history != null)
				return false;
		} else if (!history.equals(other.history))
			return false;
		if (id != other.id)
			return false;
		if (irl == null) {
			if (other.irl != null)
				return false;
		} else if (!irl.equals(other.irl))
			return false;
		if (likes != other.likes)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(picture, other.picture))
			return false;
		if (sex != other.sex)
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}

}
