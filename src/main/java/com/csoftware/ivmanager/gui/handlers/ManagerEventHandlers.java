package com.csoftware.ivmanager.gui.handlers;

import com.csoftware.ivmanager.model.*;
import com.csoftware.ivmanager.model.forms.impl.InterventionForm;
import com.csoftware.ivmanager.model.managers.impl.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.logging.Logger;

public interface ManagerEventHandlers {

	public static final EventHandler<ActionEvent> VIEW_HOSPITALS = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			Logger.getLogger("Viewer Controller").info("Opening Hospital Viewer");
			HospitalManager manager = new HospitalManager(new Hospital[0]);
			manager.showForm();
		}
	};
	
	public static final EventHandler<ActionEvent> VIEW_IMPACTS = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			Logger.getLogger("Viewer Controller").info("Opening Impact Viewer");
			ImpactManager manager = new ImpactManager(new Impact[0]);
			manager.showForm();
		}
	};
	
	public static final EventHandler<ActionEvent> VIEW_STAFF_RANKS = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			Logger.getLogger("Viewer Controller").info("Opening Staff Rank Viewer");
			StaffRankManager manager = new StaffRankManager(new StaffRank[0]);
			manager.showForm();
		}
	};
	
	public static final EventHandler<ActionEvent> VIEW_PATIENTS = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			Logger.getLogger("Viewer Controller").info("Opening Patient Viewer");
			PatientManager manager = new PatientManager(new Patient[0]);
			manager.showForm();
		}
	};
	
	public static final EventHandler<ActionEvent> VIEW_STAFF = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			Logger.getLogger("Viewer Controller").info("Opening Staff Viewer");
			StaffManager manager = new StaffManager(new CompleteStaff[0]);
			manager.showForm();
		}
	};
	
	public static final EventHandler<ActionEvent> VIEW_WARDS = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			Logger.getLogger("Viewer Controller").info("Opening Ward Viewer");
			WardManager manager = new WardManager(new CompleteWard[0]);
			manager.showForm();
		}
	};
	
	public static final EventHandler<ActionEvent> NEW_INTERVENTION = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			Logger.getLogger("Intervention Manager").info("Creating New Intervention");
			InterventionForm form = new InterventionForm(null);
			form.showForm();
		}
	};
	
//	public static final EventHandler<ActionEvent> PRINT_RECORD = new EventHandler<ActionEvent>() {
//		@Override
//		public void handle(ActionEvent event) {
//			InterventionRecord item = ManagerFrame.tablePane.getTable().getSelectionModel().getSelectedItem();
//			if(item != null){
//				Printing.print(item);
//			}
//		}
//	};
	
}
