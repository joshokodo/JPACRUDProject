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
	
	private int price;
	
	@Column(name="wanted_alive")
	private char wantedAlive;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Crime crime;
	
	private String nickname;

	
	// constructors
	public Bounty() { }
	public Bounty(String firstName, String lastName, int price, char wantedAlive,
			String description, Crime crime, String nickname) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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
	
	// hashCode and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crime == null) ? 0 : crime.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + price;
		result = prime * result + wantedAlive;
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
		Bounty other = (Bounty) obj;
		if (crime != other.crime)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (price != other.price)
			return false;
		if (wantedAlive != other.wantedAlive)
			return false;
		return true;
	}
	
	

}
