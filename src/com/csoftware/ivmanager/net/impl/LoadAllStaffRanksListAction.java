package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.StaffRank;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;
import com.google.gson.Gson;

import javafx.scene.control.ListView;

public class LoadAllStaffRanksListAction implements NetAction {
	
	ListView<StaffRank>  list;
	public LoadAllStaffRanksListAction(ListView<StaffRank> list) {
		this.list = list;
		list.getItems().clear();
	}
	
	@Override
	public void process() {
		String res = NetTransfer.getRequest("staffrank/all");
		if(!res.isEmpty()){
			Gson gson = new Gson();
			StaffRank[] staff = gson.fromJson(res, StaffRank[].class);
			if(staff != null){
				list.getItems().addAll(staff);
			}
		}
	}
	
}
