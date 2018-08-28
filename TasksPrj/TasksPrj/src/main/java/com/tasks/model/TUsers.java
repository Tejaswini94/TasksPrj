package com.tasks.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tusers")
public class TUsers {
	@Id
	@Column(name="userid")
	private String userId;
	@Column(name="fullname")
	private String fullName;
	@Column(name="emailid")
	private String emailId;
	@Column(name="password")
	private String password;
	@Column(name="role")
	private String role;
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="taskUsers")
	//@JoinTable(name="taskusers", joinColumns=@JoinColumn(name="userid"), inverseJoinColumns=@JoinColumn(name="taskid"))
	private List<Tasks> taskList=new ArrayList<>();
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="usertemplates", joinColumns=@JoinColumn(name="userid"), inverseJoinColumns=@JoinColumn(name="templateid"))
	private List<Template> templates=new ArrayList<>();
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Tasks> getTaskList() {
		return taskList;
	}
	public void setTaskList(List<Tasks> taskList) {
		this.taskList = taskList;
	}
	
}
