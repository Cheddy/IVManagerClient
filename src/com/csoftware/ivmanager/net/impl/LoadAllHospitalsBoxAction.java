package com.csoftware.ivmanager.net.impl;

import com.csoftware.ivmanager.model.Hospital;
import com.csoftware.ivmanager.net.NetAction;
import com.csoftware.ivmanager.net.NetTransfer;
import com.google.gson.Gson;

import javafx.scene.control.ComboBox;

public class LoadAllHospitalsBoxAction implements NetAction {

	ComboBox<Hospital>  box;
	public LoadAllHospitalsBoxAction(ComboBox<Hospital> box) {
		this.box = box;
	}
	
	@Override
	public void process() {
		String res = NetTransfer.getRequest("hospital/all");
		if(!res.isEmpty()){
			Gson gson = new Gson();
			Hospital[] ranks = gson.fromJson(res, Hospital[].class);
			if(ranks != null){
				Hospital current = box.getSelectionModel().getSelectedItem();
				box.getItems().clear();
				box.getItems().addAll(ranks);
				if(current != null){
					for(Hospital i : box.getItems()){
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
