package com.csoftware.ivmanager.model.forms.impl;

import com.csoftware.ivmanager.gui.components.*;
import com.csoftware.ivmanager.model.*;
import com.csoftware.ivmanager.model.forms.AbstractForm;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import org.joda.time.DateTime;

public class InterventionForm extends AbstractForm<CompleteIntervention> {
	
	private BoundObjectField<Patient> patientField;
	private BoundObjectField<CompleteWard> wardField;
	private DateTimeField dateTimeField;
	private ActionList actionList;
	private BoundObjectField<Impact> impactField;
	private DetailList detailList;
	private OutcomeList outcomeList;
	private CheckBox verifiedBox, completedBox;
	
	public InterventionForm(CompleteIntervention object) {
		super(object);
		setMaximized(true);
	}
	
	@Override
	public CompleteIntervention getObject() {
		if (original == null) {
			original = new CompleteIntervention();
		}
		original.setPatient(patientField.getSelectionModel().getSelectedItem());
		original.setWard(wardField.getSelectionModel().getSelectedItem());
		original.setDateTime(dateTimeField.getDate());
		original.setDetails(detailList.getSummary());
		original.setActions(actionList.getSummary());
		original.setOutcomes(outcomeList.getSummary());
		original.setVerified(verifiedBox.isSelected());
		original.setCompleted(completedBox.isSelected());
		original.setImpact(impactField.getSelectionModel().getSelectedItem());
		return original;
	}
	
	public void dispatchListUpdates() {
		for (InterventionDetail detail : detailList.altered) {
		
		}
		for (InterventionDetail detail : detailList.deleted) {
		
		}
		for (InterventionAction action : actionList.altered) {
		
		}
		for (InterventionAction action : actionList.deleted) {
		
		}
		for (InterventionOutcome outcome : outcomeList.altered) {
		
		}
		for (InterventionOutcome outcome : outcomeList.deleted) {
		
		}
	}
	
	@Override
	public void fillListStage() {
		Label nameLabel = new Label("Patient: ");
		patientField = new BoundObjectField<Patient>(Patient.class, original != null ? original.getPatient() : null);
		listStage.getChildren().addAll(nameLabel, patientField);
		
		Label wardLabel = new Label("Ward: ");
		wardField = new BoundObjectField<CompleteWard>(CompleteWard.class, original != null ? original.getWard() : null);
		listStage.getChildren().addAll(wardLabel, wardField);
		
		Label dateTimeLabel = new Label("Date/Time: ");
		dateTimeField = new DateTimeField(original != null ? original.getDateTime() : DateTime.now());
		listStage.getChildren().addAll(dateTimeLabel, dateTimeField);
		
		Label detailListLabel = new Label("Details: ");
		detailList = new DetailList(original != null ? original.getDetails() : null);
		listStage.getChildren().addAll(detailListLabel, detailList);
		
		Label verifiedLabel = new Label("Verified: ");
		verifiedBox = new CheckBox();
		verifiedBox.setSelected(original != null && original.isVerified());
		listStage.getChildren().addAll(verifiedLabel, verifiedBox);
		
		Label actionListLabel = new Label("Actions Taken: ");
		actionList = new ActionList(original != null ? original.getActions() : null);
		listStage.getChildren().addAll(actionListLabel, actionList);
		
		Label outcomeListLabel = new Label("Outcomes: ");
		outcomeList = new OutcomeList(original != null ? original.getOutcomes() : null);
		listStage.getChildren().addAll(outcomeListLabel, outcomeList);
		
		Label impactLabel = new Label("Impact: ");
		impactField = new BoundObjectField<Impact>(Impact.class, original != null ? original.getImpact() : null);
		listStage.getChildren().addAll(impactLabel, impactField);
		
		Label completedLabel = new Label("Completed: ");
		completedBox = new CheckBox();
		completedBox.setSelected(original != null && original.isCompleted());
		listStage.getChildren().addAll(completedLabel, completedBox);
	}
	
}
