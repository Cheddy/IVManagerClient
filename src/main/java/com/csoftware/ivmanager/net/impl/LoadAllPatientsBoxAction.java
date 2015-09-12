package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.Patient;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;
import com.csoftware.ivmanager.net.NetTransfer.DateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Platform;
import javafx.scene.control.ComboBox;

import java.sql.Date;

public class LoadAllPatientsBoxAction implements NetAction {
	
	ComboBox<Patient> box;
	
	public LoadAllPatientsBoxAction(ComboBox<Patient> box) {
		this.box = box;
	}
	
	@Override
	public void process() {
		String res = NetTransfer.getRequest("patient/all");
		if (!res.isEmpty()) {
			GsonBuilder builder = new GsonBuilder();
			builder.registerTypeAdapter(Date.class, new DateAdapter());
			Gson gson = builder.create();
			Patient[] ranks = gson.fromJson(res, Patient[].class);
			if (ranks != null) {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						Patient current = box.getSelectionModel().getSelectedItem();
						box.getItems().clear();
						box.getItems().addAll(ranks);
						if (current != null) {
							for (Patient i : box.getItems()) {
								if (i.equals(current)) {
									box.getSelectionModel().select(i);
									break;
								}
							}
						}
					}
				});
				
			}
		}
	}
	
}
