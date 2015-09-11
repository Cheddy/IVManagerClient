package com.csoftware.ivmanager.model.managers.impl;

import com.csoftware.ivmanager.data.Constants;
import com.csoftware.ivmanager.gui.ManagerFrame;
import com.csoftware.ivmanager.model.CompleteWard;
import com.csoftware.ivmanager.model.forms.impl.WardForm;
import com.csoftware.ivmanager.model.managers.AbstractManager;

import javafx.collections.FXCollections;
import javafx.scene.control.ListView;

public class WardManager extends AbstractManager<CompleteWard> {
	
	public ListView<CompleteWard> list;
	
	public WardManager(CompleteWard[] objects) {
		super(objects);
	}
	
	@Override
	public CompleteWard[] getObjects() {
		return list.getItems().toArray(new CompleteWard[list.getItems().size()]);
	}
	
	@Override
	public void deleteObject() {
		CompleteWard item = list.getSelectionModel().getSelectedItem();
		if(item != null){
			onDelete(item);
		}
	}
	
	@Override
	public void editObject() {
		CompleteWard item = list.getSelectionModel().getSelectedItem();
		CompleteWard patient = new WardForm(item).showForm();
		if(patient != null){
			onEdit(patient);
		}
	}
	
	@Override
	public void newObject() {
		CompleteWard patient = new WardForm(null).showForm();
		if (patient != null){
			onAdd(patient);
		}
	}
	
	@Override
	public void fillListStage() {
		list = new ListView<CompleteWard>(FXCollections.observableArrayList(original));
		ManagerFrame.netTransfer.loadWards(list);
		listStage.getChildren().add(list);
	}

	@Override
	public int getNewPermission() {
		return Constants.EDIT_STAFF_PERMISSION;
	}

	@Override
	public int getEditPermission() {
		return Constants.EDIT_STAFF_PERMISSION;
	}

	@Override
	public int getDeletePermission() {
		return Constants.DELETE_STAFF_PERMISSION;
	}

	@Override
	public void onAdd(CompleteWard ward) {
		ManagerFrame.netTransfer.updateWard(ward);
		ManagerFrame.netTransfer.loadWards(list);
	}

	@Override
	public void onEdit(CompleteWard ward) {
		ManagerFrame.netTransfer.updateWard(ward);
		ManagerFrame.netTransfer.loadWards(list);
	}

	@Override
	public void onDelete(CompleteWard ward) {
		ManagerFrame.netTransfer.deleteWard(ward);
		ManagerFrame.netTransfer.loadWards(list);
	}
	
}
