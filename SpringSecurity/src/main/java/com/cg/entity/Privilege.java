package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Privilege {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String privilege;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public Privilege(String privilege) {
		super();

		this.privilege = privilege;
	}

	public Privilege() {
		super();
	}

	@Override
	public String toString() {
		return "Privilege [id=" + id + ", privilege=" + privilege + "]";
	}

	
}
