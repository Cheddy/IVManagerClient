package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.Patient;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;
import com.csoftware.ivmanager.net.NetTransfer.DateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.scene.control.ListView;

import java.sql.Date;

public class LoadAllPatientsListAction implements NetAction {
	
	ListView<Patient> list;
	
	public LoadAllPatientsListAction(ListView<Patient> list) {
		this.list = list;
	}
	
	@Override
	public void process() {
		String res = NetTransfer.getRequest("patient/all");
		if (!res.isEmpty()) {
			GsonBuilder builder = new GsonBuilder();
			builder.registerTypeAdapter(Date.class, new DateAdapter());
			Gson gson = builder.create();
			Patient[] staff = gson.fromJson(res, Patient[].class);
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
