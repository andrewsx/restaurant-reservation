package edu.nyu.pqs.assignment5;

import java.time.LocalDateTime;

public class Person {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private LocalDateTime currentTime;
	private int numPeople;
	
	public Person(String firstName, String lastName, String phoneNumber, String email, int numPeople) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.currentTime = LocalDateTime.now();
		this.numPeople = numPeople;
	}
	
	public int getPartyCount() {
		return numPeople;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	
	public void setNumPeople(int num) {
		numPeople = num;
	}
	
}
