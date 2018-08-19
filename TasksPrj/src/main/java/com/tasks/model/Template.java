package com.tasks.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="templates")
public class Template {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int templateId;
	private String subject;
	private int duration;
	@OneToOne(fetch=FetchType.EAGER)
	private String adminUserId;
	private int templateType;
	private String status;
	private int frequency;
	private int priority;
	private List<Tasks> taskList=new ArrayList<>();
}
