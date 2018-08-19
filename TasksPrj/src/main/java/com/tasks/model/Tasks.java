package com.tasks.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int taskid;
	private int taskType;
	private String description;
	private Date stdate, enddate; 
	int percentComplete;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="taskUsers", joinColumns=@JoinColumn(name="taskId"), inverseJoinColumns=@JoinColumn(name="userId"))
	private List<TUsers> taskUsers=new ArrayList<>();
}
