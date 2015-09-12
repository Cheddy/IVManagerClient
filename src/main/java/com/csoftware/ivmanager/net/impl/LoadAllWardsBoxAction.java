package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.CompleteWard;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;
import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.scene.control.ComboBox;

public class LoadAllWardsBoxAction implements NetAction {
	
	ComboBox<CompleteWard> box;
	
	public LoadAllWardsBoxAction(ComboBox<CompleteWard> box) {
		this.box = box;
	}
	
	@Override
	public void process() {
		String res = NetTransfer.getRequest("ward/all");
		if (!res.isEmpty()) {
			Gson gson = new Gson();
			CompleteWard[] ranks = gson.fromJson(res, CompleteWard[].class);
			if (ranks != null) {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						CompleteWard current = box.getSelectionModel().getSelectedItem();
						box.getItems().clear();
						box.getItems().addAll(ranks);
						if (current != null) {
							for (CompleteWard i : box.getItems()) {
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
