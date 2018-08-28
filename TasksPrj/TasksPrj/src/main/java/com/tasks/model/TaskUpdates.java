package com.tasks.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="updates")
public class TaskUpdates {
	
	@Id
	@Column(name="updateId")
	private int updateId;
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name="updateInfo")
	private String updateInfo;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	private TUsers user;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="taskId")
	private Tasks tasks;
	public int getUpdateId() {
		return updateId;
	}
	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUpdateInfo() {
		return updateInfo;
	}
	public void setUpdateInfo(String updateInfo) {
		this.updateInfo = updateInfo;
	}
	public TUsers getUser() {
		return user;
	}
	public void setUser(TUsers user) {
		this.user = user;
	}
	public Tasks getTask() {
		return tasks;
	}
	public void setTask(Tasks task) {
		this.tasks = task;
	}
	
}
