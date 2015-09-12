package com.csoftware.ivmanager.model;

public class StaffRank {
	
	private long id = -1;
	private String name;
	private int permissions = 0;
	
	public StaffRank() {
	}
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the permissions
	 */
	public int getPermissions() {
		return permissions;
	}
	
	/**
	 * @param permissions
	 *            the permissions to set
	 */
	public void setPermissions(int permissions) {
		this.permissions = permissions;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof StaffRank) {
			return ((StaffRank) obj).getId() == getId();
		}
		return false;
	}
}
