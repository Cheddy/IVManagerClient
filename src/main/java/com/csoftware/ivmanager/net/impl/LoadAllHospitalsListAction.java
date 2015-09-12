package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.Hospital;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;
import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.scene.control.ListView;

public class LoadAllHospitalsListAction implements NetAction {
	
	ListView<Hospital> list;
	
	public LoadAllHospitalsListAction(ListView<Hospital> list) {
		this.list = list;
	}
	
	@Override
	public void process() {
		String res = NetTransfer.getRequest("hospital/all");
		if (!res.isEmpty()) {
			Gson gson = new Gson();
			Hospital[] staff = gson.fromJson(res, Hospital[].class);
			if (staff != null) {
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
