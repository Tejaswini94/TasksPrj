package com.tasks.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="tasks")
public class Tasks {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int taskid;
	@Column(name="tasktype")
	private int taskType;
	@Column(name="description")
	private String description;
	@Column(name="status")
	String status;
	@Column(name="stdate")
	private Date stdate;
	@Column(name="enddate")
	private Date enddate; 
	@Column(name="percentcomplete")
	int percentComplete;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="taskusers", joinColumns=@JoinColumn(name="taskid"), inverseJoinColumns=@JoinColumn(name="userid"))
	private List<TUsers> taskUsers=new ArrayList<>();
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="templateid")
	private Template template;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="tasks")
	private List<TaskUpdates> updates=new ArrayList<>();
	public Tasks(int taskid, String description, String status, Date stdate, Date enddate, int percentComplete, ArrayList<TUsers> users, Template temp,
			ArrayList<TaskUpdates> taskUpdates) {
		this.taskid = taskid;
		this.description = description;
		this.status = status;
		this.stdate = stdate;
		this.enddate = enddate;
		this.taskUsers = users;
		this.percentComplete = percentComplete;
		this.template = temp;
		this.updates = taskUpdates;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public int getTaskType() {
		return taskType;
	}
	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStdate() {
		return stdate;
	}
	public void setStdate(Date stdate) {
		this.stdate = stdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public int getPercentComplete() {
		return percentComplete;
	}
	public void setPercentComplete(int percentComplete) {
		this.percentComplete = percentComplete;
	}
	public List<TUsers> getTaskUsers() {
		return taskUsers;
	}
	public void setTaskUsers(List<TUsers> taskUsers) {
		this.taskUsers = taskUsers;
	}
	public Template getTemplate() {
		return template;
	}
	public void setTemplate(Template template) {
		this.template = template;
	}
	
}
