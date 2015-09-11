package com.csoftware.ivmanager.model.managers.impl;

import javafx.collections.FXCollections;
import javafx.scene.control.ListView;

import com.csoftware.ivmanager.data.Constants;
import com.csoftware.ivmanager.gui.ManagerFrame;
import com.csoftware.ivmanager.model.Hospital;
import com.csoftware.ivmanager.model.forms.impl.HospitalForm;
import com.csoftware.ivmanager.model.managers.AbstractManager;

public class HospitalManager extends AbstractManager<Hospital> {
	
	private ListView<Hospital> list;
	
	public HospitalManager(Hospital[] objects) {
		super(objects);
	}
	
	@Override
	public Hospital[] getObjects() {
		return list.getItems().toArray(new Hospital[list.getItems().size()]);
	}
	
	@Override
	public void deleteObject() {
		Hospital item = list.getSelectionModel().getSelectedItem();
		if(item != null){
			onDelete(item);
		}
	}
	
	@Override
	public void editObject() {
		Hospital item = list.getSelectionModel().getSelectedItem();
		Hospital hospital = new HospitalForm(item).showForm();
		if(hospital != null){
			onEdit(hospital);
		}
	}
	
	@Override
	public void newObject() {
		Hospital hospital = new HospitalForm(null).showForm();
		if (hospital != null){
			onAdd(hospital);
		}
	}
	
	@Override
	public void fillListStage() {
		list = new ListView<Hospital>(FXCollections.observableArrayList(original));
		ManagerFrame.netTransfer.loadHospitals(list);
		listStage.getChildren().add(list);
	}

	@Override
	public int getNewPermission() {
		return Constants.EDIT_HOSPITAL_PERMISSION;
	}

	@Override
	public int getEditPermission() {
		return Constants.EDIT_HOSPITAL_PERMISSION;
	}

	@Override
	public int getDeletePermission() {
		return Constants.DELETE_HOSPITAL_PERMISSION;
	}

	@Override
	public void onAdd(Hospital hospital) {
		ManagerFrame.netTransfer.updateHospital(hospital);
	}

	@Override
	public void onEdit(Hospital hospital) {
		ManagerFrame.netTransfer.updateHospital(hospital);
	}

	@Override
	public void onDelete(Hospital hospital) {
		ManagerFrame.netTransfer.deleteHospital(hospital);
	}
	
}
