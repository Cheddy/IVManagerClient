package com.csoftware.ivmanager.model.managers.impl;

import com.csoftware.ivmanager.data.Constants;
import com.csoftware.ivmanager.gui.ManagerFrame;
import com.csoftware.ivmanager.model.Impact;
import com.csoftware.ivmanager.model.forms.impl.ImpactForm;
import com.csoftware.ivmanager.model.managers.AbstractManager;

import javafx.collections.FXCollections;
import javafx.scene.control.ListView;

public class ImpactManager extends AbstractManager<Impact> {
	
	private ListView<Impact> list;
	
	public ImpactManager(Impact[] objects) {
		super(objects);
	}
	
	@Override
	public Impact[] getObjects() {
		return list.getItems().toArray(new Impact[list.getItems().size()]);
	}
	
	@Override
	public void deleteObject() {
		Impact item = list.getSelectionModel().getSelectedItem();
		if (item != null) {
			onDelete(item);
		}
	}
	
	@Override
	public void editObject() {
		Impact item = list.getSelectionModel().getSelectedItem();
		Impact impact = new ImpactForm(item).showForm();
		if (impact != null) {
			onEdit(impact);
		}
	}
	
	@Override
	public void newObject() {
		Impact impact = new ImpactForm(null).showForm();
		if (impact != null) {
			onAdd(impact);
		}
	}
	
	@Override
	public void fillListStage() {
		list = new ListView<Impact>(FXCollections.observableArrayList(original));
		ManagerFrame.netTransfer.loadImpacts(list);
		listStage.getChildren().add(list);
	}
	
	@Override
	public int getNewPermission() {
		return Constants.EDIT_IMPACT_PERMISSION;
	}
	
	@Override
	public int getEditPermission() {
		return Constants.EDIT_IMPACT_PERMISSION;
	}
	
	@Override
	public int getDeletePermission() {
		return Constants.DELETE_IMPACT_PERMISSION;
	}
	
	@Override
	public void onAdd(Impact object) {
		ManagerFrame.netTransfer.updateImpact(object);
	}
	
	@Override
	public void onEdit(Impact object) {
		ManagerFrame.netTransfer.updateImpact(object);
	}
	
	@Override
	public void onDelete(Impact object) {
		ManagerFrame.netTransfer.deleteImpact(object);
	}
	
}
