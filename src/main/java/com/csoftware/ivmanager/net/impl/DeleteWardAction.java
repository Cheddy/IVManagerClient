package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.CompleteWard;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;

public class DeleteWardAction implements NetAction {
	
	CompleteWard ward;
	public DeleteWardAction(CompleteWard ward) {
		this.ward = ward;
	}
	
	@Override
	public void process() {
		NetTransfer.postRequest("ward/delete", ward);
	}
	
}
