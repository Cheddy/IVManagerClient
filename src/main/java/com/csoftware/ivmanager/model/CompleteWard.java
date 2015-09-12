package com.csoftware.ivmanager.model;

import com.csoftware.ivmanager.data.Constants;

public class CompleteWard {

	private long id = Constants.UNASSIGNED_ID;
	private Hospital hospital;
	private String name;
	
	public CompleteWard() {
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
	 * @return the hospital
	 */
	public Hospital getHospital() {
		return hospital;
	}

	/**
	 * @param hospital the hospital to set
	 */
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
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
		return getName() + " [" + getHospital().getName() + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof CompleteWard) {
			return ((CompleteWard) obj).getId() == getId();
		}
		return false;
	}
}
