package com.dong.friend.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	private Long id;
	
	@NotEmpty(message = "firstName is required.")
	private String firstName;
	@NotEmpty(message = "lastName is required.")
	private String lastName;
	
	public User(){
		
	}
	
	public User(Long id,String firstName, String lastName){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

}
