//package com.csoftware.ivmanager.forms;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Collections;
//
//import org.joda.time.DateTime;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.CheckBox;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.input.KeyCode;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.layout.ColumnConstraints;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.stage.Stage;
//import javafx.stage.WindowEvent;
//import net.cheddy.ivmanager.model.complete.CompleteIntervention;
//import net.cheddy.ivmanager.model.complete.CompleteWard;
//
//import com.csoftware.ivmanager.data.Constants;
//import com.csoftware.ivmanager.gui.ManagerFrame;
//import com.csoftware.ivmanager.gui.components.ActionList;
//import com.csoftware.ivmanager.gui.components.DateField;
//import com.csoftware.ivmanager.gui.components.DateTimeField;
//import com.csoftware.ivmanager.gui.components.NumberField;
//import com.csoftware.ivmanager.gui.components.OutcomesList;
//import com.csoftware.ivmanager.gui.components.SummaryList;
//import com.csoftware.ivmanager.model.Impact;
//import com.csoftware.ivmanager.model.InterventionAction;
//import com.csoftware.ivmanager.model.InterventionDetail;
//import com.csoftware.ivmanager.model.InterventionOutcome;
//import com.csoftware.ivmanager.model.Patient;
//import com.csoftware.ivmanager.model.Ward;
//import com.csoftware.ivmanager.net.DatabaseHandler;
//
//public class InterventionForm extends Stage {
//
//	private boolean goodExit = true;
//	private CompleteIntervention initial;
//
//	private TextField patientNameField;
//	private ComboBox<String> wardField;
//	private DateTimeField dateTimePicker;
//	private NumberField rtxNumberField;
//	private DateField datePicker;
//	private SummaryList summaryList;
//	private ActionList actionList;
//	private OutcomesList outcomes;
//	private ComboBox<String> impact;
//	private CheckBox completedBox;
//	private CheckBox verifiedBox;
//
//	public InterventionForm(CompleteIntervention record) {
//		this.initial = record;
//		CompleteWard ward = null;
//		Patient patient = null;
//		LocalDate dob = LocalDate.now();
//		DateTime date = DateTime.now();
//		long rtx = 0;
//		ArrayList<InterventionDetail> details = new ArrayList<InterventionDetail>();
//		ArrayList<InterventionAction> actions = new ArrayList<InterventionAction>();
//		ArrayList<InterventionOutcome> outcomes = new ArrayList<InterventionOutcome>();
//		Impact impact = null;
//		boolean completed = false;
//		boolean verified = false;
//		if (record != null) {
//			patient = record.getPatient();
//			ward = record.getWard();
//			date = record.getDateTime();
//			Collections.addAll(details, record.getDetails());
//			Collections.addAll(actions, record.getActions());
//			Collections.addAll(outcomes, record.getOutcomes());
//			impact = record.getImpact();
//			completed = record.isCompleted();
//			verified = record.isVerified();
//		}
//
//		setWidth(Constants.WINDOW_BOUNDS.getWidth());
//		setHeight(Constants.WINDOW_BOUNDS.getHeight());
//		setTitle(Constants.PROGRAM_NAME + " - Intervention Form");
//
//		GridPane grid = new GridPane();
//		grid.setPadding(new Insets(15));
//		grid.setHgap(10);
//		grid.setVgap(10);
//		grid.setAlignment(Pos.CENTER);
//
//		Label nameLabel = new Label("Patient Name: ");
//		patientNameField = new TextField(patient.toString());
//		grid.add(nameLabel, 0, 0);
//		grid.add(patientNameField, 1, 0);
//
//		Label wardLabel = new Label("Ward: ");
//		wardField = new ComboBox<>();
//		wardField.setEditable(true);
//		wardField.setMaxWidth(Double.MAX_VALUE);
//		grid.add(wardLabel, 0, 1);
//		grid.add(wardField, 1, 1);
//
//		Label rtxLabel = new Label("RTX Number: ");
//		rtxNumberField = new NumberField(rtx);
//		grid.add(rtxLabel, 0, 2);
//		grid.add(rtxNumberField, 1, 2);
//
//		Label dateLabel = new Label("Date/Time: ");
//		dateTimePicker = new DateTimeField(date);
//		grid.add(dateLabel, 0, 3);
//		grid.add(dateTimePicker, 1, 3);
//
//		HBox buttonGroup = new HBox(10);
//		Button newButton = new Button("New");
//		newButton.setOnAction(ADD_DETAIL);
//		Button delButton = new Button("Delete");
//		delButton.setOnAction(DEL_DETAIL);
//		buttonGroup.getChildren().addAll(newButton, delButton);
//		grid.add(buttonGroup, 1, 6);
//		
//		Label verifiedLabel = new Label("Verified: ");
//		verifiedBox = new CheckBox();
//		verifiedBox.setSelected(verified);
//		grid.add(verifiedLabel, 0, 7);
//		grid.add(verifiedBox, 1, 7);
//		
//
//
//		HBox buttonGroup2 = new HBox(10);
//		Button newButton2 = new Button("New");
//		newButton2.setOnAction(ADD_ACTION);
//		Button delButton2 = new Button("Delete");
//		delButton2.setOnAction(DEL_ACTION);
//		buttonGroup2.getChildren().addAll(newButton2, delButton2);
//		grid.add(buttonGroup2, 1, 9);
//
//
//		HBox buttonGroup3 = new HBox(10);
//		Button newButton3 = new Button("New");
//		newButton3.setOnAction(ADD_OUTCOME);
//		Button delButton3 = new Button("Delete");
//		delButton3.setOnAction(DEL_OUTCOME);
//		buttonGroup3.getChildren().addAll(newButton3, delButton3);
//		grid.add(buttonGroup3, 1, 11);
//
//		Label impactLabel = new Label("Impact: ");
//		ObservableList<String> list = FXCollections.observableArrayList(Constants.IMPACTS);
//		this.impact = new ComboBox<>(list);
//		grid.add(impactLabel, 0, 12);
//		grid.add(this.impact, 1, 12);
//		
//		Label completedLabel = new Label("Completed: ");
//		completedBox = new CheckBox();
//		completedBox.setSelected(completed);
//		grid.add(completedLabel, 0, 13);
//		grid.add(completedBox, 1, 13);
//		
//		Button btnSaveButton = new Button("Save");
//		btnSaveButton.setOnKeyReleased(new EventHandler<KeyEvent>() {
//			@Override
//			public void handle(KeyEvent event) {
//				if (event.getCode() == KeyCode.ENTER) {
//					hide();
//				}
//			}
//		});
//		btnSaveButton.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				hide();
//			}
//		});
//
//		grid.add(btnSaveButton, 0, 14, 2, 1);
//
//		ColumnConstraints column = new ColumnConstraints();
//		column.setPercentWidth(30);
//		grid.getColumnConstraints().add(column);
//
//		column = new ColumnConstraints();
//		column.setPercentWidth(70);
//		grid.getColumnConstraints().add(column);
//
//		setScene(new Scene(grid));
//		setOnCloseRequest(new EventHandler<WindowEvent>() {
//			public void handle(WindowEvent e) {
//				InterventionForm.this.goodExit = false;
//			}
//		});
//	}
//
//	public CompleteIntervention getRecord() {
//		showAndWait();
//		if (!goodExit) {
//			return initial;
//		}
//		if (initial == null)
//			initial = new CompleteIntervention();
//		boolean complete = initial.isCompleted();
//		boolean verified = initial.isVerified();
//		initial.setStaffName(Constants.USERNAME);
//		initial.setPatientName(patientNameField.getText());
//		initial.setWard(wardField.getSelectionModel().getSelectedItem());
//		initial.setRTXNumber(rtxNumberField.getLong());
//		initial.setDateOfBirth(datePicker.getDate());
//		initial.setDateTime(dateTimePicker.getDate());
//		initial.setDetails(summaryList.getSummary());
//		initial.setActions(actionList.getSummary());
//		initial.setOutcome(outcomes.getSummary());
//		initial.setImpact(impact.getSelectionModel().getSelectedItem());
//		initial.setCompleted(completedBox.isSelected());
//		initial.setVerified(verifiedBox.isSelected());
//		
//		if(!complete && initial.isCompleted()){
//			initial.setCompletedDateTime(LocalDateTime.now());
//			initial.setCompletedStaffName(Constants.USERNAME);
//		}else if(complete && !initial.isCompleted()){
//			initial.setCompletedDateTime(LocalDateTime.now());
//			initial.setCompletedStaffName("");
//		}
//		
//		if(!verified && initial.isVerified()){
//			initial.setVerifiedDateTime(LocalDateTime.now());
//			initial.setVerifiedStaffName(Constants.USERNAME);
//		}else if(verified && !initial.isVerified()){
//			initial.setVerifiedDateTime(LocalDateTime.now());
//			initial.setVerifiedStaffName("");
//		}
//		
//		if(!ManagerFrame.tablePane.getRawData().contains(initial)){
//			ManagerFrame.tablePane.getRawData().add(initial);
//		}
//		
//		StorableCompleteIntervention rec = initial.toStorable();
//		initial.counter = DatabaseHandler.putRecord(rec);
//		
//		
//		ManagerFrame.toolBar.generatePredicate();
//		return initial;
//	}
//
//	public final EventHandler<ActionEvent> ADD_DETAIL = new EventHandler<ActionEvent>() {
//		@Override
//		public void handle(ActionEvent event) {
//			SummaryItem item = new ItemForm("", "", null, ManagerFrame.tablePane.getDetailDescs()).getDetailedItem();
//			if (item != null)
//				summaryList.getItems().add(item);
//		}
//	};
//
//	public final EventHandler<ActionEvent> DEL_DETAIL = new EventHandler<ActionEvent>() {
//		@Override
//		public void handle(ActionEvent event) {
//			SummaryItem i = summaryList.getSelectionModel().getSelectedItem();
//			if (i != null)
//				summaryList.getItems().remove(i);
//		}
//	};
//
//	public final EventHandler<ActionEvent> ADD_ACTION = new EventHandler<ActionEvent>() {
//		@Override
//		public void handle(ActionEvent event) {
//			ActionSummary.SummaryItem item = new ItemForm("", "", LocalDate.now(), ManagerFrame.tablePane.getActionDescs()).getActionItem();
//			if (item != null)
//				actionList.getItems().add(item);
//		}
//	};
//
//	public final EventHandler<ActionEvent> DEL_ACTION = new EventHandler<ActionEvent>() {
//		@Override
//		public void handle(ActionEvent event) {
//			com.csoftware.ivmanager.data.records.ActionSummary.SummaryItem i = actionList.getSelectionModel().getSelectedItem();
//			if (i != null)
//				actionList.getItems().remove(i);
//		}
//	};
//
//	public final EventHandler<ActionEvent> ADD_OUTCOME = new EventHandler<ActionEvent>() {
//		@Override
//		public void handle(ActionEvent event) {
//			ActionSummary.SummaryItem item = new ItemForm("", "", LocalDate.now(), ManagerFrame.tablePane.getOutcomeDescs()).getActionItem();
//			if (item != null)
//				outcomes.getItems().add(item);
//		}
//	};
//
//	public final EventHandler<ActionEvent> DEL_OUTCOME = new EventHandler<ActionEvent>() {
//		@Override
//		public void handle(ActionEvent event) {
//			com.csoftware.ivmanager.data.records.ActionSummary.SummaryItem i = outcomes.getSelectionModel().getSelectedItem();
//			if (i != null)
//				outcomes.getItems().remove(i);
//		}
//	};
//	
//}
