package com.csoftware.ivmanager.model;

import com.csoftware.ivmanager.data.Constants;


public class Hospital {

	private long id = Constants.UNASSIGNED_ID;
	private String name;
	
	public Hospital() {
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Hospital) {
			return ((Hospital) obj).getId() == getId();
		}
		return false;
	}
	
}
