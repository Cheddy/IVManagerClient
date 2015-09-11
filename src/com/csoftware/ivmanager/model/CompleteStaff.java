package com.csoftware.ivmanager.model;

import com.csoftware.ivmanager.data.Constants;

public class CompleteStaff {

	private long id = Constants.UNASSIGNED_ID;
	private String username;
	private String surname;
	private String othernames;
	private String passwordHash;
	private StaffRank rank;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the othernames
	 */
	public String getOthernames() {
		return othernames;
	}

	/**
	 * @param othernames
	 *            the othernames to set
	 */
	public void setOthernames(String othernames) {
		this.othernames = othernames;
	}

	/**
	 * @return the passwordHash
	 */
	public String getPasswordHash() {
		return passwordHash;
	}

	/**
	 * @param passwordHash
	 *            the passwordHash to set
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	/**
	 * @return the rank
	 */
	public StaffRank getRank() {
		return rank;
	}

	/**
	 * @param rank
	 *            the rank to set
	 */
	public void setRank(StaffRank rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return getOthernames()+ " " + getSurname();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof CompleteStaff) {
			return ((CompleteStaff) obj).getId() == getId();
		}
		return false;
	}
}
