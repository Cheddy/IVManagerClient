package com.csoftware.ivmanager.gui;

import com.csoftware.ivmanager.model.CompleteIntervention;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.function.Predicate;

public class ManagerTablePane {

//	private final TableView<CompleteIntervention> table = new TableView<>();
//	private final ObservableList<CompleteIntervention> rawData = FXCollections.observableArrayList();
//	private FilteredList<CompleteIntervention> filtered;
//	private SortedList<CompleteIntervention> sorted;
//
//	public ManagerTablePane() {
//		getTable().setEditable(false);
//		initiateColumns();
//
//		getTable().setTableMenuButtonVisible(true);
//		getTable().setVisible(true);
//		getTable().setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//		filtered = new FilteredList<CompleteIntervention>(rawData, TRUE_PREDICATE);
//		sorted = new SortedList<CompleteIntervention>(filtered);
//		sorted.comparatorProperty().bind(getTable().comparatorProperty());
//		getTable().setFocusTraversable(false);
//		getTable().setItems(sorted);
//		getTable().getSelectionModel().setCellSelectionEnabled(false);
//	}
//
//	private void initiateColumns() {
//		getTable().setRowFactory(value -> {
//			TableRow<CompleteIntervention> row = new TableRow<>();
//			row.setOnMouseClicked(event -> {
//				if (event.getClickCount() == 2 && (!row.isEmpty())) {
//					CompleteIntervention record = row.getItem();
//					new InterventionForm(record).getRecord();
//					reload();
//				}
//			});
//			return row;
//		});
//
//		String name = Constants.TRAINING_OVERVIEW_COLUMN_HEADINGS[0];
//		TableColumn<CompleteIntervention, String> col = new TableColumn<CompleteIntervention, String>(name);
//		col.setMinWidth(10.0);
//		col.setCellValueFactory(new PropertyValueFactory<CompleteIntervention, String>(name.replace(" ", "")));
//		col.setComparator(STRING_COMPARATOR);
//		col.setSortable(true);
//		getTable().getColumns().add(col);
//
//		name = Constants.TRAINING_OVERVIEW_COLUMN_HEADINGS[1];
//		TableColumn<CompleteIntervention, String> dateTimeCol = new TableColumn<CompleteIntervention, String>(name);
//		dateTimeCol.setMinWidth(10.0);
//		dateTimeCol.setCellValueFactory(new Callback<CellDataFeatures<CompleteIntervention, String>, ObservableValue<String>>() {
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<CompleteIntervention, String> c) {
//				return new SimpleStringProperty(c.getValue().getDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
//			}
//		});
//		dateTimeCol.setComparator(DATE_TIME_COMPARATOR);
//		dateTimeCol.setSortable(true);
//		getTable().getColumns().add(dateTimeCol);
//
//		name = Constants.TRAINING_OVERVIEW_COLUMN_HEADINGS[2];
//		col = new TableColumn<CompleteIntervention, String>(name);
//		col.setMinWidth(10.0);
//		col.setCellValueFactory(new PropertyValueFactory<CompleteIntervention, String>(name.replace(" ", "")));
//		col.setComparator(STRING_COMPARATOR);
//		col.setSortable(true);
//		getTable().getColumns().add(col);
//
//		name = Constants.TRAINING_OVERVIEW_COLUMN_HEADINGS[3];
//		dateTimeCol = new TableColumn<CompleteIntervention, String>(name);
//		dateTimeCol.setMinWidth(10.0);
//		dateTimeCol.setCellValueFactory(new Callback<CellDataFeatures<CompleteIntervention, String>, ObservableValue<String>>() {
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<CompleteIntervention, String> c) {
//				if(c.getValue().isVerified() && c.getValue().getVerifiedDateTime() != null){
//				return new SimpleStringProperty(c.getValue().getVerifiedDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
//				}else{
//					return new SimpleStringProperty("");
//				}
//			}
//		});
//		dateTimeCol.setComparator(DATE_TIME_COMPARATOR);
//		dateTimeCol.setSortable(true);
//		getTable().getColumns().add(dateTimeCol);
//
//		name = Constants.TRAINING_OVERVIEW_COLUMN_HEADINGS[4];
//		col = new TableColumn<CompleteIntervention, String>(name);
//		col.setMinWidth(10.0);
//		col.setCellValueFactory(new PropertyValueFactory<CompleteIntervention, String>(name.replace(" ", "")));
//		col.setComparator(STRING_COMPARATOR);
//		col.setSortable(true);
//		getTable().getColumns().add(col);
//
//		name = Constants.TRAINING_OVERVIEW_COLUMN_HEADINGS[5];
//		col = new TableColumn<CompleteIntervention, String>(name);
//		col.setMinWidth(10.0);
//		col.setCellValueFactory(new PropertyValueFactory<CompleteIntervention, String>(name.replace(" ", "")));
//		col.setComparator(STRING_COMPARATOR);
//		col.setSortable(true);
//		getTable().getColumns().add(col);
//		
//		name = Constants.TRAINING_OVERVIEW_COLUMN_HEADINGS[6];
//		TableColumn<CompleteIntervention, Integer> numCol = new TableColumn<CompleteIntervention, Integer>(name);
//		numCol.setMinWidth(10.0);
//		numCol.setCellValueFactory(new PropertyValueFactory<CompleteIntervention, Integer>(name.replace(" ", "")));
//		numCol.setComparator(INTEGER_COMPARATOR);
//		numCol.setSortable(true);
//		getTable().getColumns().add(numCol);
//
//		name = Constants.TRAINING_OVERVIEW_COLUMN_HEADINGS[7];
//		TableColumn<CompleteIntervention, String> dateCol = new TableColumn<CompleteIntervention, String>(name);
//		dateCol.setMinWidth(10.0);
//		dateCol.setCellValueFactory(new Callback<CellDataFeatures<CompleteIntervention, String>, ObservableValue<String>>() {
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<CompleteIntervention, String> c) {
//				return new SimpleStringProperty(c.getValue().getDateOfBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//			}
//		});
//		dateCol.setComparator(DATE_COMPARATOR);
//		dateCol.setSortable(true);
//		getTable().getColumns().add(dateCol);
//
//		name = Constants.TRAINING_OVERVIEW_COLUMN_HEADINGS[8];
//		dateCol = new TableColumn<CompleteIntervention, String>(name);
//		dateCol.setMinWidth(10.0);
//		dateCol.setCellValueFactory(new Callback<CellDataFeatures<CompleteIntervention, String>, ObservableValue<String>>() {
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<CompleteIntervention, String> c) {
//				return new SimpleStringProperty(c.getValue().getDetails().toString());
//			}
//		});
//		dateCol.setComparator(STRING_COMPARATOR);
//		dateCol.setSortable(true);
//		getTable().getColumns().add(dateCol);
//
//		name = Constants.TRAINING_OVERVIEW_COLUMN_HEADINGS[9];
//		dateCol = new TableColumn<CompleteIntervention, String>(name);
//		dateCol.setMinWidth(10.0);
//		dateCol.setCellValueFactory(new Callback<CellDataFeatures<CompleteIntervention, String>, ObservableValue<String>>() {
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<CompleteIntervention, String> c) {
//				return new SimpleStringProperty(c.getValue().getActions().toString());
//			}
//		});
//		dateCol.setComparator(STRING_COMPARATOR);
//		dateCol.setSortable(true);
//		getTable().getColumns().add(dateCol);
//
//		name = Constants.TRAINING_OVERVIEW_COLUMN_HEADINGS[10];
//		dateCol = new TableColumn<CompleteIntervention, String>(name);
//		dateCol.setMinWidth(10.0);
//		dateCol.setCellValueFactory(new Callback<CellDataFeatures<CompleteIntervention, String>, ObservableValue<String>>() {
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<CompleteIntervention, String> c) {
//				return new SimpleStringProperty(c.getValue().getOutcome().toString());
//			}
//		});
//		dateCol.setComparator(STRING_COMPARATOR);
//		dateCol.setSortable(true);
//		getTable().getColumns().add(dateCol);
//
//		name = Constants.TRAINING_OVERVIEW_COLUMN_HEADINGS[11];
//		col = new TableColumn<CompleteIntervention, String>(name);
//		col.setMinWidth(10.0);
//		col.setCellValueFactory(new Callback<CellDataFeatures<CompleteIntervention, String>, ObservableValue<String>>() {
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<CompleteIntervention, String> c) {
//				if(c.getValue().getCompletedStaffName() == null){
//					return new SimpleStringProperty("");
//				}
//				return new SimpleStringProperty(c.getValue().getCompletedStaffName());
//			}
//		});
//		col.setComparator(STRING_COMPARATOR);
//		col.setSortable(true);
//		getTable().getColumns().add(col);
//		
//		name = Constants.TRAINING_OVERVIEW_COLUMN_HEADINGS[12];
//		dateTimeCol = new TableColumn<CompleteIntervention, String>(name);
//		dateTimeCol.setMinWidth(10.0);
//		dateTimeCol.setCellValueFactory(new Callback<CellDataFeatures<CompleteIntervention, String>, ObservableValue<String>>() {
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<CompleteIntervention, String> c) {
//				if(c.getValue().isCompleted() && c.getValue().getCompletedDateTime() != null){
//				return new SimpleStringProperty(c.getValue().getCompletedDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
//				}else{
//					return new SimpleStringProperty("");
//				}
//			}
//		});
//		dateTimeCol.setComparator(DATE_TIME_COMPARATOR);
//		dateTimeCol.setSortable(true);
//		getTable().getColumns().add(dateTimeCol);
//		
//		name = Constants.TRAINING_OVERVIEW_COLUMN_HEADINGS[13];
//		col = new TableColumn<CompleteIntervention, String>(name);
//		col.setMinWidth(10.0);
//		col.setCellValueFactory(new PropertyValueFactory<CompleteIntervention, String>(name.replace(" ", "")));
//		col.setComparator(STRING_COMPARATOR);
//		col.setSortable(true);
//		getTable().getColumns().add(col);
//	}
//
//	public void reload() {
//		getTable().getColumns().get(0).setVisible(false);
//		getTable().getColumns().get(0).setVisible(true);
//	}
//
//	/**
//	 * @return the filtered
//	 */
//	public FilteredList<CompleteIntervention> getFiltered() {
//		return filtered;
//	}
//
//	/**
//	 * @param filtered
//	 *            the filtered to set
//	 */
//	public void setFiltered(FilteredList<CompleteIntervention> filtered) {
//		this.filtered = filtered;
//	}
//
//	/**
//	 * @return the table
//	 */
//	public TableView<CompleteIntervention> getTable() {
//		return table;
//	}
//
//	/**
//	 * @return the rawData
//	 */
//	public ObservableList<CompleteIntervention> getRawData() {
//		return rawData;
//	}

//	public ObservableList<String> getWards() {
//		ObservableList<String> wards = FXCollections.observableArrayList();
//		for (CompleteIntervention r : rawData) {
//			if (r.getWard() != null && !wards.contains(r.getWard())) {
//				wards.add(r.getWard());
//			}
//		}
//		return wards;
//	}
//
//	public ObservableList<String> getActionDescs() {
//		ObservableList<String> desc = FXCollections.observableArrayList();
//		for (CompleteIntervention r : rawData) {
//			if (r.getActions() != null) {
//				for (SummaryItem item : r.getActions().items) {
//					if (item != null && item.description != null && !desc.contains(item.description)) {
//						desc.add(item.description);
//					}
//				}
//			}
//		}
//		return desc;
//	}
//	
//	public ObservableList<String> getOutcomeDescs() {
//		ObservableList<String> desc = FXCollections.observableArrayList();
//		for (CompleteIntervention r : rawData) {
//			if (r.getOutcome() != null) {
//				for (SummaryItem item : r.getOutcome().items) {
//					if (item != null && item.description != null && !desc.contains(item.description)) {
//						desc.add(item.description);
//					}
//				}
//			}
//		}
//		return desc;
//	}
//	
//	public ObservableList<String> getDetailDescs() {
//		ObservableList<String> desc = FXCollections.observableArrayList();
//		for (CompleteIntervention r : rawData) {
//			if (r.getDetails() != null) {
//				for (DetailedSummary.SummaryItem item : r.getDetails().items) {
//					if (item != null && item.description != null && !desc.contains(item.description)) {
//						desc.add(item.description);
//					}
//				}
//			}
//		}
//		return desc;
//	}

	public static final Comparator<String> STRING_COMPARATOR = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
	};

	public static final Comparator<Integer> INTEGER_COMPARATOR = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
	};

	public static final Comparator<String> DATE_TIME_COMPARATOR = new Comparator<String>() {
		@Override
		public int compare(String s1, String s2) {
			LocalDateTime o1 = LocalDateTime.parse(s1, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
			LocalDateTime o2 = LocalDateTime.parse(s2, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
			return o1.isAfter(o2) ? -1 : o1.isEqual(o2) ? 0 : 1;
		}
	};

	public static final Comparator<String> DATE_COMPARATOR = new Comparator<String>() {
		@Override
		public int compare(String s1, String s2) {
			LocalDate o1 = LocalDate.parse(s1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			LocalDate o2 = LocalDate.parse(s2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			return o1.isAfter(o2) ? -1 : o1.isEqual(o2) ? 0 : 1;
		}
	};

	public static final Predicate<CompleteIntervention> TRUE_PREDICATE = new Predicate<CompleteIntervention>() {
		@Override
		public boolean test(CompleteIntervention t) {
			return !t.isVerified() && !t.isCompleted();
		}
	};
}
