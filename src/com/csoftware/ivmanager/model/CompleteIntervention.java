package com.csoftware.ivmanager.model;

import org.joda.time.DateTime;

import com.csoftware.ivmanager.data.Constants;

public class CompleteIntervention {

		private long id = Constants.UNASSIGNED_ID;
		private Patient patient;
		private CompleteWard ward;
		private CompleteStaff staff;
		private DateTime dateTime;
		private boolean verified;
		private DateTime verifiedDateTime;
		private CompleteStaff verifiedStaff;
		private boolean completed;
		private DateTime completedDateTime;
		private CompleteStaff completedStaff;
		private InterventionDetail[] details;
		private InterventionAction[] actions;
		private InterventionOutcome[] outcomes;
		private Impact impact;

		public CompleteIntervention() {
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
		 * @return the patient
		 */
		public Patient getPatient() {
			return patient;
		}

		/**
		 * @param patient the patient to set
		 */
		public void setPatient(Patient patient) {
			this.patient = patient;
		}

		/**
		 * @return the ward
		 */
		public CompleteWard getWard() {
			return ward;
		}

		/**
		 * @param ward the ward to set
		 */
		public void setWard(CompleteWard ward) {
			this.ward = ward;
		}

		/**
		 * @return the staff
		 */
		public CompleteStaff getStaff() {
			return staff;
		}

		/**
		 * @param staff the staff to set
		 */
		public void setStaff(CompleteStaff staff) {
			this.staff = staff;
		}

		/**
		 * @return the dateTime
		 */
		public DateTime getDateTime() {
			return dateTime;
		}

		/**
		 * @param dateTime the dateTime to set
		 */
		public void setDateTime(DateTime dateTime) {
			this.dateTime = dateTime;
		}

		/**
		 * @return the verified
		 */
		public boolean isVerified() {
			return verified;
		}

		/**
		 * @param verified the verified to set
		 */
		public void setVerified(boolean verified) {
			this.verified = verified;
		}

		/**
		 * @return the verifiedDateTime
		 */
		public DateTime getVerifiedDateTime() {
			return verifiedDateTime;
		}

		/**
		 * @param verifiedDateTime the verifiedDateTime to set
		 */
		public void setVerifiedDateTime(DateTime verifiedDateTime) {
			this.verifiedDateTime = verifiedDateTime;
		}

		/**
		 * @return the verifiedStaff
		 */
		public CompleteStaff getVerifiedStaff() {
			return verifiedStaff;
		}

		/**
		 * @param verifiedStaff the verifiedStaff to set
		 */
		public void setVerifiedStaff(CompleteStaff verifiedStaff) {
			this.verifiedStaff = verifiedStaff;
		}

		/**
		 * @return the completed
		 */
		public boolean isCompleted() {
			return completed;
		}

		/**
		 * @param completed the completed to set
		 */
		public void setCompleted(boolean completed) {
			this.completed = completed;
		}

		/**
		 * @return the completedDateTime
		 */
		public DateTime getCompletedDateTime() {
			return completedDateTime;
		}

		/**
		 * @param completedDateTime the completedDateTime to set
		 */
		public void setCompletedDateTime(DateTime completedDateTime) {
			this.completedDateTime = completedDateTime;
		}

		/**
		 * @return the completedStaff
		 */
		public CompleteStaff getCompletedStaff() {
			return completedStaff;
		}

		/**
		 * @param completedStaff the completedStaff to set
		 */
		public void setCompletedStaff(CompleteStaff completedStaff) {
			this.completedStaff = completedStaff;
		}

		/**
		 * @return the details
		 */
		public InterventionDetail[] getDetails() {
			return details;
		}

		/**
		 * @param details the details to set
		 */
		public void setDetails(InterventionDetail[] details) {
			this.details = details;
		}

		/**
		 * @return the actions
		 */
		public InterventionAction[] getActions() {
			return actions;
		}

		/**
		 * @param actions the actions to set
		 */
		public void setActions(InterventionAction[] actions) {
			this.actions = actions;
		}

		/**
		 * @return the outcomes
		 */
		public InterventionOutcome[] getOutcomes() {
			return outcomes;
		}

		/**
		 * @param outcomes the outcomes to set
		 */
		public void setOutcomes(InterventionOutcome[] outcomes) {
			this.outcomes = outcomes;
		}

		/**
		 * @return the impact
		 */
		public Impact getImpact() {
			return impact;
		}

		/**
		 * @param impact the impact to set
		 */
		public void setImpact(Impact impact) {
			this.impact = impact;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj != null && obj instanceof CompleteIntervention) {
				return ((CompleteIntervention) obj).getId() == getId();
			}
			return false;
		}
		
}
