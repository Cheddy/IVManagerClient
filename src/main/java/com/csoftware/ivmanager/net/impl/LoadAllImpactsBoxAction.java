package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.Impact;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;
import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.scene.control.ComboBox;

public class LoadAllImpactsBoxAction implements NetAction {
	
	ComboBox<Impact> box;
	
	public LoadAllImpactsBoxAction(ComboBox<Impact> box) {
		this.box = box;
	}
	
	@Override
	public void process() {
		String res = NetTransfer.getRequest("impact/all");
		if (!res.isEmpty()) {
			Gson gson = new Gson();
			Impact[] ranks = gson.fromJson(res, Impact[].class);
			if (ranks != null) {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						Impact current = box.getSelectionModel().getSelectedItem();
						box.getItems().clear();
						box.getItems().addAll(ranks);
						if (current != null) {
							for (Impact i : box.getItems()) {
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
