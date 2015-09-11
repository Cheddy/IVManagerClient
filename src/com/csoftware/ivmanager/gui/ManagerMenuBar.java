package com.csoftware.ivmanager.gui;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

import com.csoftware.ivmanager.data.Constants;
import com.csoftware.ivmanager.gui.handlers.ManagerEventHandlers;

public class ManagerMenuBar extends MenuBar implements ManagerEventHandlers {
	
	public ManagerMenuBar() {
		initaliseFileMenu();
	}
	
	private void initaliseFileMenu() {
		Menu fileMenu = new Menu("File");
		
		if ((Constants.userPermissions & Constants.VIEW_HOSPITAL_PERMISSION) != 0) {
			MenuItem viewHospitals = new MenuItem("View Hospitals");
			viewHospitals.setAccelerator(new KeyCodeCombination(KeyCode.H, KeyCombination.CONTROL_DOWN));
			viewHospitals.setOnAction(VIEW_HOSPITALS);
			fileMenu.getItems().add(viewHospitals);
		}
		if ((Constants.userPermissions & Constants.VIEW_IMPACT_PERMISSION) != 0) {
			MenuItem viewImpacts = new MenuItem("View Impacts");
			viewImpacts.setAccelerator(new KeyCodeCombination(KeyCode.I, KeyCombination.CONTROL_DOWN));
			viewImpacts.setOnAction(VIEW_IMPACTS);
			fileMenu.getItems().add(viewImpacts);
		}
		if ((Constants.userPermissions & Constants.VIEW_STAFF_RANK_PERMISSION) != 0) {
			MenuItem viewStaffRanks = new MenuItem("View Staff Ranks");
			viewStaffRanks.setAccelerator(new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN));
			viewStaffRanks.setOnAction(VIEW_STAFF_RANKS);
			fileMenu.getItems().add(viewStaffRanks);
		}
		if ((Constants.userPermissions & Constants.VIEW_PATIENT_PERMISSION) != 0) {
			MenuItem viewStaffRanks = new MenuItem("View Patients");
			viewStaffRanks.setAccelerator(new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN));
			viewStaffRanks.setOnAction(VIEW_PATIENTS);
			fileMenu.getItems().add(viewStaffRanks);
		}
		
		MenuItem viewStaffRanks = new MenuItem("View Staff");
		viewStaffRanks.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
		viewStaffRanks.setOnAction(VIEW_STAFF);
		fileMenu.getItems().add(viewStaffRanks);
		
		getMenus().add(fileMenu);
	}
	
}
