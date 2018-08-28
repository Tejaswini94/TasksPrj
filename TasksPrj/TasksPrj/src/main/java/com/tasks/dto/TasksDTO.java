package com.tasks.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.tasks.model.TUsers;
import com.tasks.model.TaskUpdates;
import com.tasks.model.Template;

public class TasksDTO {
	private int taskid;
	private int taskType;
	private String description;
	String status;
	private Date stdate;
	private Date enddate; 
	int percentComplete;
	private List<TUsers> taskUsers=new ArrayList<>();
	private Template template;
	private List<TaskUpdates> updates=new ArrayList<>();
}
