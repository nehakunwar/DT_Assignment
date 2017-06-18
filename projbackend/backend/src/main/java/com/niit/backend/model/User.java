package com.niit.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Proj_user")
@Component
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
	
@Column(unique=true,nullable=false)
private String username;

@Column(nullable=false)
private String password;

@Column(unique=true,nullable=false)
private String email;



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


@Override
public String toString() {
	return this.username + " " + this.email + " " +  "\n";
}
}