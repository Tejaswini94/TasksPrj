package com.tasks.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="updates")
@Getter
@Setter
public class TaskUpdates {

	private int updateId;
	private Date date;
	private String updateInfo;
	@OneToOne
	private TUsers user;
	@OneToOne
	private Tasks task;
}
