package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.Patient;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;
import com.google.gson.Gson;

import javafx.scene.control.ListView;

public class LoadAllPatientsListAction implements NetAction {
	
	ListView<Patient>  list;
	public LoadAllPatientsListAction(ListView<Patient> list) {
		this.list = list;
		list.getItems().clear();
	}
	
	@Override
	public void process() {
		String res = NetTransfer.getRequest("patient/all");
		if(!res.isEmpty()){
			Gson gson = new Gson();
			Patient[] staff = gson.fromJson(res, Patient[].class);
			if(staff != null){
				list.getItems().addAll(staff);
			}
		}
	}
	
}
