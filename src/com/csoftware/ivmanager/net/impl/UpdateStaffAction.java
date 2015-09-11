package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.CompleteStaff;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;

public class UpdateStaffAction implements NetAction {
	
	CompleteStaff staff;
	public UpdateStaffAction(CompleteStaff staff) {
		this.staff = staff;
	}
	
	@Override
	public void process() {
		NetTransfer.postRequest("staff/save", staff);
	}
	
}
