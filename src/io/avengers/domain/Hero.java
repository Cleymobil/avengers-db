package io.avengers.domain;

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
	
	public Hero(){
	
	}

	public Hero(int id, String name, Sex sex, long likes, long dislikes, byte[] picture, String abilities, String history) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.likes = likes;
		this.dislikes = dislikes;
		this.picture=picture;
		this.abilities = abilities;
		this.history=history;
		this.team=null;
		this.irl=null;
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
	
}
