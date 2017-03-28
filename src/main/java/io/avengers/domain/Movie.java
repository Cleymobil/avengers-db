package io.avengers.domain;

import java.util.Arrays;
import java.util.Base64;

import javax.xml.bind.annotation.XmlTransient;

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
	public Movie(String name, long gross, long budget, String history) {

		this.name = name;
		this.gross = gross;
		this.budget = budget;
		this.history = history;

	}

	public Movie() {
	}

	public Movie(String name, long gross, long budget) {
		this.name = name;
		this.gross = gross;
		this.budget = budget;
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

	@XmlTransient
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

	@Override
	public String toString() {
		return "\nid=" + this.id + ",\n name=" + this.name + ",\n picture=" + Arrays.toString(picture) + ",\n date="
				+ this.date + ",\n history=" + this.history + ",\n gross=" + this.gross + ",\n budget=" + this.budget
				+ "\n";
	}

	@XmlTransient
	public String getPictureString() {
		if (picture == null) {
			return "";
		}
		byte[] encodedImage = Base64.getEncoder().encode(picture);
		String pict = "data:image/jpeg;base64," + new String(encodedImage);
		return pict;
	}
}
