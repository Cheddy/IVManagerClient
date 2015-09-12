package com.csoftware.ivmanager.model;

import com.csoftware.ivmanager.data.Constants;
import org.joda.time.LocalDate;

import java.sql.Date;

public class Patient {
	
	private long id = Constants.UNASSIGNED_ID;
	private long rtx;
	private Date dob;
	private String surname;
	private String othernames;
	
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
	 * @return the rtx
	 */
	public long getRtx() {
		return rtx;
	}
	
	/**
	 * @param rtx
	 *            the rtx to set
	 */
	public void setRtx(long rtx) {
		this.rtx = rtx;
	}
	
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	
	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
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
	
	@Override
	public String toString() {
		return getRtx() + ": " + getOthernames() + " " + getSurname();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Patient) {
			return ((Patient) obj).getId() == getId();
		}
		return false;
	}
	
	public static LocalDate dateToLocalDate(Date d) {
		if (d == null)
			return null;
		return new LocalDate(d.getTime());
	}
	
	public static Date localdateToDate(LocalDate ld) {
		if (ld == null)
			return null;
		return new Date(ld.toDateTimeAtStartOfDay().getMillis());
	}
	
}
