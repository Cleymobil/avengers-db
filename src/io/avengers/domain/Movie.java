package io.avengers.domain;

public class Movie {

	int id;
	String name;
	byte[] picture;
	java.util.Date date;
	String history;
	long gross;
	long budget;

	public Movie(int id, String name, long gross, long budget, byte[] picture, String history, java.util.Date date) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.gross = gross;
		this.budget = budget;
		this.history = history;

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

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public long getGross() {
		return gross;
	}

	public void setGross(long gross) {
		this.gross = gross;
	}

	public long getBudget() {
		return budget;
	}

	public void setBudget(long budget) {
		this.budget = budget;
	}

}
