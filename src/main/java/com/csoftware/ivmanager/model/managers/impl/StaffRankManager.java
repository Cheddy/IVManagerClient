package com.csoftware.ivmanager.model.managers.impl;

import com.csoftware.ivmanager.data.Constants;
import com.csoftware.ivmanager.gui.ManagerFrame;
import com.csoftware.ivmanager.model.StaffRank;
import com.csoftware.ivmanager.model.forms.impl.StaffRankForm;
import com.csoftware.ivmanager.model.managers.AbstractManager;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;

public class StaffRankManager extends AbstractManager<StaffRank> {
	
	private ListView<StaffRank> list;
	
	public StaffRankManager(StaffRank[] objects) {
		super(objects);
	}
	
	@Override
	public StaffRank[] getObjects() {
		return list.getItems().toArray(new StaffRank[list.getItems().size()]);
	}
	
	@Override
	public void deleteObject() {
		StaffRank item = list.getSelectionModel().getSelectedItem();
		if(item != null){
			list.getItems().remove(item);
			onDelete(item);
		}
	}
	
	@Override
	public void editObject() {
		StaffRank item = list.getSelectionModel().getSelectedItem();
		StaffRank hospital = new StaffRankForm(item).showForm();
		if(hospital != null){
			onEdit(hospital);
		}
	}
	
	@Override
	public void newObject() {
		StaffRank staffRank = new StaffRankForm(null).showForm();
		if (staffRank != null){
			onAdd(staffRank);
		}
	}
	
	@Override
	public void fillListStage() {
		list = new ListView<StaffRank>(FXCollections.observableArrayList(original));
		ManagerFrame.netTransfer.loadStaffRanks(list);
		listStage.getChildren().add(list);
	}

	@Override
	public int getNewPermission() {
		return Constants.EDIT_STAFF_RANK_PERMISSION;
	}

	@Override
	public int getEditPermission() {
		return Constants.EDIT_STAFF_RANK_PERMISSION;
	}

	@Override
	public int getDeletePermission() {
		return Constants.DELETE_STAFF_RANK_PERMISSION;
	}

	@Override
	public void onAdd(StaffRank staffRank) {
		ManagerFrame.netTransfer.updateStaffRank(staffRank);
		ManagerFrame.netTransfer.loadStaffRanks(list);
	}

	@Override
	public void onEdit(StaffRank staffRank) {
		ManagerFrame.netTransfer.updateStaffRank(staffRank);
		ManagerFrame.netTransfer.loadStaffRanks(list);
	}

	@Override
	public void onDelete(StaffRank staffRank) {
		ManagerFrame.netTransfer.deleteStaffRank(staffRank);
		ManagerFrame.netTransfer.loadStaffRanks(list);
	}
	
}
