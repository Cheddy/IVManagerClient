package com.csoftware.ivmanager.model.forms.impl;

import org.joda.time.LocalDate;

import com.csoftware.ivmanager.gui.components.DateField;
import com.csoftware.ivmanager.gui.components.NumberField;
import com.csoftware.ivmanager.model.Patient;
import com.csoftware.ivmanager.model.forms.AbstractForm;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PatientForm extends AbstractForm<Patient> {

	private TextField surnameField;
	private TextField otherNameField;
	private NumberField rtxField;
	private DateField dobField;

	public PatientForm(Patient object) {
		super(object);
	}

	@Override
	public Patient getObject() {
		if(original == null){
			original = new Patient();
		}
		original.setSurname(surnameField.getText());
		original.setOthernames(otherNameField.getText());
		original.setRtx(rtxField.getLong());
		original.setDob(Patient.localdateToDate(dobField.getDate()));
		return original;
	}

	@Override
	public void fillListStage() {
		Label surnameLabel = new Label("Surname: ");
		surnameField = new TextField(original != null? original.getSurname():"");
		listStage.getChildren().addAll(surnameLabel,surnameField);	
		
		Label otherNameLabel = new Label("Other Names: ");
		otherNameField = new TextField(original != null? original.getOthernames():"");
		listStage.getChildren().addAll(otherNameLabel,otherNameField);	
		
		Label rtxLabel = new Label("RTX: ");
		rtxField = new NumberField(original != null? original.getRtx():-1);
		listStage.getChildren().addAll(rtxLabel,rtxField);	
		
		Label dobLabel = new Label("DOB: ");
		dobField = new DateField(original != null? Patient.dateToLocalDate(original.getDob()):LocalDate.now());
		listStage.getChildren().addAll(dobLabel,dobField);	
	}
	
}
