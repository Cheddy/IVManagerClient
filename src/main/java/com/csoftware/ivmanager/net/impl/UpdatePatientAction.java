package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.Patient;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;

public class UpdatePatientAction implements NetAction {
	
	Patient patient;
	public UpdatePatientAction(Patient patient) {
		this.patient = patient;
	}
	
	@Override
	public void process() {
		NetTransfer.postRequest("patient/save", patient);
	}
	
}
