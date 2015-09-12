package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.Impact;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;
import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.scene.control.ListView;

public class LoadAllImpactsListAction implements NetAction {
	
	ListView<Impact> list;
	
	public LoadAllImpactsListAction(ListView<Impact> list) {
		this.list = list;
	}
	
	@Override
	public void process() {
		String res = NetTransfer.getRequest("impact/all");
		if (!res.isEmpty()) {
			Gson gson = new Gson();
			Impact[] staff = gson.fromJson(res, Impact[].class);
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
