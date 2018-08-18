package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tusers")
public class TUsers {
	@Id
	private String userId;
	private String fname, lname;
	private String emailId;
	private String password;
	private String role;
	
}
