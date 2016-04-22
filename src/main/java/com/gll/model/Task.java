package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int taskId;
	
	/* What type of task it is? Is it UX Designer task or Content Writer task? etc */
	private UserPin taskType;
	
	/*
	 * The Person who will assign task to the team, should explain the needful
	 * to be done, in taskStroy
	 */
	private String taskStory;
	
	/* To whom task is assigned (Example: Is it assigned to Content Writer or UX Designer?)*/
	@ManyToOne
	private int assignedTo;
	
	/* taskStatus will contain: done, in-progress, failed etc; */
	private String taskStatus;
	
	/*Date of Starting of the task.*/
	private Date taskStartDate;
	
	/* Date of end of the task. */
	private Date taskEndDate;
	
	
}
