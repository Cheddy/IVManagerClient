package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.Patient;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;

public class DeletePatientAction implements NetAction {
	
	Patient patient;
	public DeletePatientAction(Patient patient) {
		this.patient = patient;
	}
	
	@Override
	public void process() {
		NetTransfer.postRequest("patient/delete", patient);
	}
	
}
