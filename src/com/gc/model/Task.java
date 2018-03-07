package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // marks the class as a hibernate entity (mapped class)
@Table(name = "task") // maps the class to the DB table specified by the name modifier

public class Task {
	private int taskId;
	private String usernameHost;
	private String date;
	private String time;
	private int estimatedTime;
	private String skillsNeeded;
	private String city;
	private String title;
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(int taskId, String usernameHost, String date, String time, int estimatedTime,
			String skillsNeeded, String city, String title) {
		super();
		this.taskId = taskId;
		this.usernameHost = usernameHost;
		this.date = date;
		this.time = time;
		this.estimatedTime = estimatedTime;
		this.skillsNeeded = skillsNeeded;
		this.city = city;
		this.title = title;
	}
	
	@Id
	@Column (name = "TaskID")
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	@Column (name = "Username_Host")
	public String getUsernameHost() {
		return usernameHost;
	}
	public void setUsernameHost(String usernameHost) {
		this.usernameHost = usernameHost;
	}
	@Column (name = "Date")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Column (name = "Time")
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Column (name = "EstimatedTime")
	public int getEstimatedTime() {
		return estimatedTime;
	}
	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	@Column (name = "SkillsNeeded")
	public String getSkillsNeeded() {
		return skillsNeeded;
	}
	public void setSkillsNeeded(String skillsNeeded) {
		this.skillsNeeded = skillsNeeded;
	}
	@Column (name = "City")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column (name = "Title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


}