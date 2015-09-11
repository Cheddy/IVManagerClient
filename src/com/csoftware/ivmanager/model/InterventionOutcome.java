package com.csoftware.ivmanager.model;

import org.joda.time.DateTime;

import com.csoftware.ivmanager.data.Constants;


public class InterventionOutcome {

	private long id = Constants.UNASSIGNED_ID;
	private long interventionId;
	private String description;
	private String detail;
	private DateTime dateTime;

	public InterventionOutcome() {
	}

	public InterventionOutcome(String desc,String detail, DateTime dateTime) {
		this.description = desc;
		this.detail = detail;
		this.dateTime = dateTime;
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
	 * @return the interventionId
	 */
	public long getInterventionId() {
		return interventionId;
	}

	/**
	 * @param interventionId
	 *            the interventionId to set
	 */
	public void setInterventionId(long interventionId) {
		this.interventionId = interventionId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * @param detail
	 *            the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * @return the datetime
	 */
	public DateTime getDateTime() {
		return dateTime;
	}

	/**
	 * @param datetime
	 *            the datetime to set
	 */
	public void setDateTime(DateTime datetime) {
		this.dateTime = datetime;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof InterventionOutcome) {
			return ((InterventionOutcome) obj).getId() == getId();
		}
		return false;
	}
}
