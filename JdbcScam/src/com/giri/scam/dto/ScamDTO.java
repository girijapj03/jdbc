package com.giri.scam.dto;

import java.io.Serializable;
import java.util.Date;

public class ScamDTO implements Serializable{
	private int id;
	private String name;
	private Date year;
	private String by;
	private String location ;
	private String description;
	private double amount;
	public ScamDTO() {}
	public ScamDTO(int id, String name, Date year, String by, String location, String description, double amount) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.by = by;
		this.location = location;
		this.description = description;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "ScamDTO [id=" + id + ", name=" + name + ", year=" + year + ", by=" + by + ", location=" + location
				+ ", description=" + description + ", amount=" + amount + "]";
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
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	

}
