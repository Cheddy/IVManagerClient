package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.CompleteWard;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;
import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.scene.control.ListView;

public class LoadAllWardsListAction implements NetAction {
	
	ListView<CompleteWard> list;
	
	public LoadAllWardsListAction(ListView<CompleteWard> list) {
		this.list = list;
	}
	
	@Override
	public void process() {
		String res = NetTransfer.getRequest("ward/all");
		if (!res.isEmpty()) {
			Gson gson = new Gson();
			CompleteWard[] staff = gson.fromJson(res, CompleteWard[].class);
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
