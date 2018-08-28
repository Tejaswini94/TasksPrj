package com.tasks.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.tasks.enums.Frequencies;
import com.tasks.model.TUsers;
import com.tasks.model.Tasks;

public class TemplateDTO {
	private int templateId;
	private String subject;
	private int duration;
	private TUsers user;
	private int templateType;
	private String status;
	private int frequency;
	private String recurringFrequency;
	private int priority;
	private String tPriority;
	//private List<Tasks> taskList=new ArrayList<>();
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
	public TUsers getUser() {
		return user;
	}
	public void setUser(TUsers user) {
		this.user = user;
	}
	public int getTemplateType() {
		return templateType;
	}
	public void setTemplateType(int templateType) {
		this.templateType = templateType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public String getRecurringFrequency() {
		return Frequencies.getFrequency(getFrequency()).name();
	}
	public void setRecurringFrequency(String recurringFrequency) {
		this.recurringFrequency = recurringFrequency;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String gettPriority() {
		if(getPriority()==1)
		return "Low";
		if(getPriority()==2)
		return "Normal";
		if(getPriority()==3)
		return "High";
		return "";
	}
	public void settPriority(String tPriority) {
		this.tPriority = tPriority;
	}
/*	public List<Tasks> getTaskList() {
		return taskList;
	}
	public void setTaskList(List<Tasks> taskList) {
		this.taskList = taskList;
	}*/
	
}
