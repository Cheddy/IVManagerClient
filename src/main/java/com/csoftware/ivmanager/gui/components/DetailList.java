package com.csoftware.ivmanager.gui.components;

import com.csoftware.ivmanager.model.InterventionDetail;
import com.csoftware.ivmanager.model.forms.impl.InterventionDetailForm;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.HashSet;

public class DetailList extends VBox {
	
	ListView<InterventionDetail> listView;
	public HashSet<InterventionDetail> altered = new HashSet<>();
	public HashSet<InterventionDetail> deleted = new HashSet<>();
	Button newButton, editButton, deleteButton;
	
	public DetailList(InterventionDetail[] summary) {
		if (summary == null)
			summary = new InterventionDetail[0];
		listView = new ListView<>(FXCollections.observableArrayList(summary));
		listView.setEditable(false);
		listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (e.getClickCount() >= 2) {
					editSelected();
					listView.getSelectionModel().clearSelection();
				}
			}
		});
		setSpacing(10);
		HBox box = new HBox(10);
		newButton = new Button("New");
		newButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				addNew();
			}
		});
		editButton = new Button("Edit");
		editButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				addNew();
			}
		});
		deleteButton = new Button("Delete");
		deleteButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				addNew();
			}
		});
		box.getChildren().addAll(newButton, editButton, deleteButton);
		getChildren().addAll(listView, box);
	}
	
	public void addNew() {
		InterventionDetailForm form = new InterventionDetailForm(null);
		InterventionDetail item = form.showForm();
		listView.getItems().add(item);
		altered.add(item);
		reload();
	}
	
	public void editSelected() {
		InterventionDetail item = listView.getSelectionModel().getSelectedItem();
		if (item != null) {
			InterventionDetailForm form = new InterventionDetailForm(item);
			form.showForm();
			altered.add(item);
			reload();
		}
	}
	
	public void deleteSelected() {
		InterventionDetail item = listView.getSelectionModel().getSelectedItem();
		if (item != null) {
			if (listView.getItems().remove(item)) {
				deleted.add(item);
				reload();
			}
		}
	}
	
	public void reload() {
		listView.refresh();
	}
	
	public InterventionDetail[] getSummary() {
		return (InterventionDetail[]) listView.getItems().toArray(new InterventionDetail[listView.getItems().size()]);
	}
	
}
