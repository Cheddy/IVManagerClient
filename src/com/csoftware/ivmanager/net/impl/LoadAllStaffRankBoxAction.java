package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.StaffRank;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;
import com.google.gson.Gson;

import javafx.scene.control.ComboBox;

public class LoadAllStaffRankBoxAction implements NetAction {
	
	ComboBox<StaffRank>  box;
	public LoadAllStaffRankBoxAction(ComboBox<StaffRank> box) {
		this.box = box;
	}
	
	@Override
	public void process() {
		String res = NetTransfer.getRequest("staffrank/all");
		if(!res.isEmpty()){
			Gson gson = new Gson();
			StaffRank[] ranks = gson.fromJson(res, StaffRank[].class);
			if(ranks != null){
				StaffRank current = box.getSelectionModel().getSelectedItem();
				box.getItems().clear();
				box.getItems().addAll(ranks);
				if(current != null){
					for(StaffRank i : box.getItems()){
						if(i.equals(current)){
							box.getSelectionModel().select(i);
							break;
						}
					}
				}
			}
		}
	}
	
}
