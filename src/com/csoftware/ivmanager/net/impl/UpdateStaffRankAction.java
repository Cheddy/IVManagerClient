package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.StaffRank;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;

public class UpdateStaffRankAction implements NetAction {
	
	StaffRank staffRank;
	public UpdateStaffRankAction(StaffRank staffRank) {
		this.staffRank = staffRank;
	}
	
	@Override
	public void process() {
		NetTransfer.postRequest("staffrank/save", staffRank);
	}
	
}
