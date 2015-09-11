package com.csoftware.ivmanager.gui.components;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import com.csoftware.ivmanager.model.InterventionOutcome;

public class OutcomesList extends ListView<InterventionOutcome> {

	InterventionOutcome[] summary;

	public OutcomesList(InterventionOutcome[] summary) {
		setEditable(false);
		if (summary == null)
			summary = new InterventionOutcome[0];
		this.summary = summary;
		setItems(FXCollections.observableArrayList(summary));
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (e.getClickCount() >= 2) {
					InterventionOutcome item = getSelectionModel().getSelectedItem();
					if (item != null) {
						reload();
						getSelectionModel().clearSelection();
					}
				}
			}
		});
	}

	public void reload() {
		ObservableList<InterventionOutcome> items = getItems();
		setItems(null);
		setItems(items);
	}

	public InterventionOutcome[] getSummary() {
		summary = getItems().toArray(new InterventionOutcome[getItems().size()]);
		return summary;
	}
}
