package com.csoftware.ivmanager.gui;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;

public class ManagerToolBar extends ToolBar {

	private TextField filter;
	private CheckBox completed;
	private CheckBox verified;

	public ManagerToolBar() {
//		filter = new TextField();
//		filter.setOnKeyTyped(predicateKeyHandler);
//		filter.setOnKeyReleased(predicateKeyHandler);
//
//		verified = new CheckBox();
//		verified.setOnAction(predicateActionHandler);
//
//		completed = new CheckBox();
//		completed.setOnAction(predicateActionHandler);

//		getItems().addAll(new Label("Search: "), filter, new Label("Verified: "), verified, new Label("Completed: "), completed);
	}

//	public void generatePredicate() {
//		if (filter.getText() != null && !filter.getText().equals("")) {
//			String term = filter.getText().toLowerCase();
//			Predicate<InterventionRecord> predicate = new Predicate<InterventionRecord>() {
//				@Override
//				public boolean test(InterventionRecord record) {
//					boolean staffName = false;
//					if (record.getStaffName() != null) {
//						staffName = record.getStaffName().toLowerCase().contains(term);
//					}
//
//					boolean patientName = false;
//					if (record.getPatientName() != null) {
//						patientName = record.getPatientName().toLowerCase().contains(term);
//					}
//
//					boolean ward = false;
//					if (record.getWard() != null) {
//						ward = record.getWard().toLowerCase().contains(term);
//					}
//
//					boolean rtxNum = false;
//					if (record.getRTXNumber() != 0) {
//						rtxNum = String.valueOf(record.getRTXNumber()).contains(term);
//					}
//
//					if (completed.isSelected() == record.isComplete() && verified.isSelected() == record.isVerified() && (staffName || patientName || ward || rtxNum)) {
//						return true;
//					}
//					return false;
//				}
//			};
//			ManagerFrame.tablePane.getFiltered().setPredicate(predicate);
//		} else {
//			ManagerFrame.tablePane.getFiltered().setPredicate(new Predicate<InterventionRecord>() {
//				@Override
//				public boolean test(InterventionRecord record) {
//					return completed.isSelected() == record.isComplete() && verified.isSelected() == record.isVerified();
//				}
//			});
//		}
//	}
//
//	EventHandler<KeyEvent> predicateKeyHandler = new EventHandler<KeyEvent>() {
//		@Override
//		public void handle(KeyEvent key) {
//			Platform.runLater(new Runnable() {
//				@Override
//				public void run() {
//					generatePredicate();
//				}
//			});
//		}
//	};
//
//	EventHandler<ActionEvent> predicateActionHandler = new EventHandler<ActionEvent>() {
//		@Override
//		public void handle(ActionEvent arg0) {
//			Platform.runLater(new Runnable() {
//				@Override
//				public void run() {
//					generatePredicate();
//				}
//			});
//		}
//	};

}
