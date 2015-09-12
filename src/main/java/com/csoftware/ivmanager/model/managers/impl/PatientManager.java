package com.csoftware.ivmanager.model.managers.impl;

import com.csoftware.ivmanager.data.Constants;
import com.csoftware.ivmanager.gui.ManagerFrame;
import com.csoftware.ivmanager.model.Patient;
import com.csoftware.ivmanager.model.forms.impl.PatientForm;
import com.csoftware.ivmanager.model.managers.AbstractManager;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;

public class PatientManager extends AbstractManager<Patient> {
	
	private ListView<Patient> list;
	
	public PatientManager(Patient[] objects) {
		super(objects);
	}
	
	@Override
	public Patient[] getObjects() {
		return list.getItems().toArray(new Patient[list.getItems().size()]);
	}
	
	@Override
	public void deleteObject() {
		Patient item = list.getSelectionModel().getSelectedItem();
		if(item != null){
			onDelete(item);
		}
	}
	
	@Override
	public void editObject() {
		Patient item = list.getSelectionModel().getSelectedItem();
		Patient patient = new PatientForm(item).showForm();
		if(patient != null){
			onEdit(patient);
		}
	}
	
	@Override
	public void newObject() {
		Patient patient = new PatientForm(null).showForm();
		if (patient != null){
			onAdd(patient);
		}
	}
	
	@Override
	public void fillListStage() {
		list = new ListView<Patient>(FXCollections.observableArrayList(original));
		ManagerFrame.netTransfer.loadPatient(list);
		listStage.getChildren().add(list);
	}

	@Override
	public int getNewPermission() {
		return Constants.EDIT_PATIENT_PERMISSION;
	}

	@Override
	public int getEditPermission() {
		return Constants.EDIT_PATIENT_PERMISSION;
	}

	@Override
	public int getDeletePermission() {
		return Constants.DELETE_PATIENT_PERMISSION;
	}

	@Override
	public void onAdd(Patient patient) {
		ManagerFrame.netTransfer.updatePatient(patient);
		ManagerFrame.netTransfer.loadPatient(list);
	}

	@Override
	public void onEdit(Patient patient) {
		ManagerFrame.netTransfer.updatePatient(patient);
		ManagerFrame.netTransfer.loadPatient(list);
	}

	@Override
	public void onDelete(Patient patient) {
		ManagerFrame.netTransfer.deletePatient(patient);
		ManagerFrame.netTransfer.loadPatient(list);
	}
	
}
