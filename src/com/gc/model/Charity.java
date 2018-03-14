package com.gc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // marks the class as a hibernate entity (mapped class)
@Table(name = "charity") // maps the class to the DB table specified by the name modifier

public class Charity implements Serializable {
	private int id;
	private String name;
	private String ein;
	
	public Charity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Charity(int id, String name, String ein) {
		super();
		this.id = id;
		this.name = name;
		this.ein = ein;
	}

	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column (name = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column (name = "EIN")
	public String getEin() {
		return ein;
	}

	public void setEin(String ein) {
		this.ein = ein;
	}
	
	
	
	
	
	
	
}