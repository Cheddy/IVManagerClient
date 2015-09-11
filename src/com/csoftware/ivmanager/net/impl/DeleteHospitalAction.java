package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.Hospital;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;

public class DeleteHospitalAction implements NetAction {
	
	Hospital hospital;
	public DeleteHospitalAction(Hospital hospital) {
		this.hospital = hospital;
	}
	
	@Override
	public void process() {
		NetTransfer.postRequest("hospital/delete", hospital);
	}
	
}
