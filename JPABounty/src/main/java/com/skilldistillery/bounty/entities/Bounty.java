package com.skilldistillery.bounty.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bounty {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="middle_initial")
	private Character middleInitial;
	
	private int price;
	
	@Column(name="wanted_alive")
	private char wantedAlive;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Crime crime;
	
	private String nickname;

	
	// constructors
	public Bounty() { }
	public Bounty(String firstName, String lastName, Character middleInitial, int price, char wantedAlive,
			String description, Crime crime, String nickname) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.price = price;
		this.wantedAlive = wantedAlive;
		this.description = description;
		this.crime = crime;
		this.nickname = nickname;
	}
	
	
	// setters and getters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Character getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(Character middleInitial) {
		this.middleInitial = middleInitial;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public char getWantedAlive() {
		return wantedAlive;
	}
	public void setWantedAlive(char wantedAlive) {
		this.wantedAlive = wantedAlive;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Crime getCrime() {
		return crime;
	}
	public void setCrime(Crime crime) {
		this.crime = crime;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getId() {
		return id;
	}
	
	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bounty [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", middleInitial=");
		builder.append(middleInitial);
		builder.append(", price=");
		builder.append(price);
		builder.append(", wantedAlive=");
		builder.append(wantedAlive);
		builder.append(", description=");
		builder.append(description);
		builder.append(", crime=");
		builder.append(crime);
		builder.append(", nickname=");
		builder.append(nickname);
		builder.append("]");
		return builder.toString();
	}
	
	

}
