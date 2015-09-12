package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.StaffRank;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;

public class DeleteStaffRankAction implements NetAction {
	
	StaffRank staffRank;
	public DeleteStaffRankAction(StaffRank staffRank) {
		this.staffRank = staffRank;
	}
	
	@Override
	public void process() {
		NetTransfer.postRequest("staffrank/delete", staffRank);
	}
	
}
