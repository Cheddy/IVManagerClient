package com.csoftware.ivmanager.gui.components;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import com.csoftware.ivmanager.model.InterventionAction;

public class ActionList extends ListView<InterventionAction> {

	InterventionAction[] summary;

	public ActionList(InterventionAction[] summary) {
		setEditable(false);
		if (summary == null)
			summary = new InterventionAction[0];
		this.summary = summary;
		setItems(FXCollections.observableArrayList(summary));
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (e.getClickCount() >= 2) {
					InterventionAction item = getSelectionModel().getSelectedItem();
					if (item != null) {
						reload();
						getSelectionModel().clearSelection();
					}
				}
			}
		});
	}

	public void reload() {
		ObservableList<InterventionAction> items = getItems();
		setItems(null);
		setItems(items);
	}

	public InterventionAction[] getSummary() {
		summary = getItems().toArray(new InterventionAction[getItems().size()]);
		return summary;
	}

}
