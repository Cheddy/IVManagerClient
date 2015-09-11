package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.Impact;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;

public class DeleteImpactAction implements NetAction {
	
	Impact impact;
	public DeleteImpactAction(Impact impact) {
		this.impact = impact;
	}
	
	@Override
	public void process() {
		NetTransfer.postRequest("impact/delete", impact);
	}
	
}
