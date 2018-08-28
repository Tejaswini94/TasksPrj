package com.tasks.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="template")
public class Template {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="templateid")
	private int templateId;
	@Column(name="subject")
	private String subject;
	@Column(name="duration")
	private int duration;
	/*@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userid")
	private TUsers user;*/
	@Column(name="ttype")
	private int templateType;
	/*@Column(name="status")
	private String status;*/
	@Column(name="recurringfrequency")
	private int frequency;
	@Column(name="priority")
	private int priority;
	public Template(int templateId, String subject, int duration, int frequency , int priority) {
		this.templateId = templateId;
		this.subject = subject;
		this.duration = duration;
		this.frequency = frequency;
		this.priority = priority;
	}
	/*@OneToMany(fetch=FetchType.LAZY)
	@JoinTable()
	private List<Tasks> taskList=new ArrayList<>();*/
	public int getTemplateId() {
		return templateId;
	}
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/*public TUsers getUser() {
		return user;
	}
	public void setUser(TUsers user) {
		this.user = user;
	}*/
	public int getTemplateType() {
		return templateType;
	}
	public void setTemplateType(int templateType) {
		this.templateType = templateType;
	}
	/*public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}*/
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/*public List<Tasks> getTaskList() {
		return taskList;
	}
	public void setTaskList(List<Tasks> taskList) {
		this.taskList = taskList;
	}*/
	
}
