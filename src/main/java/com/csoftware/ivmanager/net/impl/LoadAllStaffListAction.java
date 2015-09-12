package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.CompleteStaff;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;
import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.scene.control.ListView;

public class LoadAllStaffListAction implements NetAction {
	
	ListView<CompleteStaff>  list;
	public LoadAllStaffListAction(ListView<CompleteStaff> list) {
		this.list = list;
	}
	
	@Override
	public void process() {
		String res = NetTransfer.getRequest("staff/all");
		if(!res.isEmpty()){
			Gson gson = new Gson();
			CompleteStaff[] staff = gson.fromJson(res, CompleteStaff[].class);
			if(staff != null){
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						list.getItems().clear();
						list.getItems().addAll(staff);
					}
				});
			}
		}
	}
	
}
