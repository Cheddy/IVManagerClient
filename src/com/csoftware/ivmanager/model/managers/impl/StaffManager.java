package com.csoftware.ivmanager.model.managers.impl;

import com.csoftware.ivmanager.data.Constants;
import com.csoftware.ivmanager.gui.ManagerFrame;
import com.csoftware.ivmanager.model.CompleteStaff;
import com.csoftware.ivmanager.model.forms.impl.StaffForm;
import com.csoftware.ivmanager.model.managers.AbstractManager;

import javafx.collections.FXCollections;
import javafx.scene.control.ListView;

public class StaffManager extends AbstractManager<CompleteStaff> {
	
	public ListView<CompleteStaff> list;
	
	public StaffManager(CompleteStaff[] objects) {
		super(objects);
	}
	
	@Override
	public CompleteStaff[] getObjects() {
		return list.getItems().toArray(new CompleteStaff[list.getItems().size()]);
	}
	
	@Override
	public void deleteObject() {
		CompleteStaff item = list.getSelectionModel().getSelectedItem();
		if(item != null){
			onDelete(item);
		}
	}
	
	@Override
	public void editObject() {
		CompleteStaff item = list.getSelectionModel().getSelectedItem();
		CompleteStaff patient = new StaffForm(item).showForm();
		if(patient != null){
			onEdit(patient);
		}
	}
	
	@Override
	public void newObject() {
		CompleteStaff patient = new StaffForm(null).showForm();
		if (patient != null){
			onAdd(patient);
		}
	}
	
	@Override
	public void fillListStage() {
		list = new ListView<CompleteStaff>(FXCollections.observableArrayList(original));
		ManagerFrame.netTransfer.loadStaff(list);
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
	public void onAdd(CompleteStaff staff) {
		ManagerFrame.netTransfer.updateStaff(staff);
		ManagerFrame.netTransfer.loadStaff(list);
	}

	@Override
	public void onEdit(CompleteStaff staff) {
		ManagerFrame.netTransfer.updateStaff(staff);
		ManagerFrame.netTransfer.loadStaff(list);
	}

	@Override
	public void onDelete(CompleteStaff staff) {
		ManagerFrame.netTransfer.deleteStaff(staff);
		ManagerFrame.netTransfer.loadStaff(list);
	}
	
}
