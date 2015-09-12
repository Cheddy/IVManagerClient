package com.csoftware.ivmanager.data;

import javafx.scene.image.Image;

import java.awt.*;
import java.io.File;

public class Constants {
	
	public static final Rectangle WINDOW_BOUNDS = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	public static final String PROGRAM_NAME = "Intervention Manager";
	public static final double PROGRAM_VERSION = 0.1;

	public static final File LOCATION = new File(System.getProperty("user.home") + File.separator + PROGRAM_NAME);
	public static final File TABLE_FILE = new File(LOCATION, "table.json");

	public static final String USERNAME = System.getProperty("user.name");
	
	public static final Image LOGO;
	public static final String[] TRAINING_OVERVIEW_COLUMN_HEADINGS = {"Staff Name", "Date/Time", "Verified Staff Name", "Date Verified",  "Ward", "Patient Name", "RTX Number", "Date of Birth", "Details", "Actions", "Outcome", "Completing Staff Name", "Date Completed", "Impact"};

	public static final String[] IMPACTS = {"No Injuries", "Minor", "Moderate", "Major", "Catastrophic", "Near Miss", "Awaiting Response"};
	
	public static final boolean RUN_LOCALLY = false;
	
	public static final int VIEW_HOSPITAL_PERMISSION = 0b1;
	public static final int EDIT_HOSPITAL_PERMISSION = 0b10;
	public static final int DELETE_HOSPITAL_PERMISSION = 0b100;

	public static final int VIEW_IMPACT_PERMISSION = 0b1000;
	public static final int EDIT_IMPACT_PERMISSION = 0b10000;
	public static final int DELETE_IMPACT_PERMISSION = 0b100000;
	
	public static final int VIEW_STAFF_RANK_PERMISSION = 0b1000000;
	public static final int EDIT_STAFF_RANK_PERMISSION = 0b10000000;
	public static final int DELETE_STAFF_RANK_PERMISSION = 0b100000000;
	
	public static final int VIEW_PATIENT_PERMISSION = 0b1000000000;
	public static final int EDIT_PATIENT_PERMISSION = 0b10000000000;
	public static final int DELETE_PATIENT_PERMISSION = 0b100000000000;
	
	public static final int VIEW_STAFF_PERMISSION = 0b1000000000000;
	public static final int EDIT_STAFF_PERMISSION = 0b10000000000000;
	public static final int DELETE_STAFF_PERMISSION = 0b100000000000000;
	
	public static final int VIEW_WARD_PERMISSION = 0b1000000000000000;
	public static final int EDIT_WARD_PERMISSION = 0b10000000000000000;
	public static final int DELETE_WARD_PERMISSION = 0b100000000000000000;
	
	public static final int VIEW_INTERVENTION_PERMISSION = 0b1000000000000000000;
	public static final int EDIT_INTERVENTION_PERMISSION = 0b10000000000000000000;
	public static final int DELETE_INTERVENTION_PERMISSION = 0b100000000000000000000;
	
	public static final int UNASSIGNED_ID = -1;
	
	public static int serverIP = 7;
	public static final int userPermissions = 0b11111111111111111111111111111111;

	
	static {
		try {
			LOGO = new Image(ClassLoader.getSystemResource("resources/logo.png").toString());
		} catch (Exception e) {
			throw new RuntimeException("Could Not Load Logo!");
		}
		TABLE_FILE.setReadable(true, false);
		TABLE_FILE.setExecutable(true, false);
		TABLE_FILE.setWritable(true, false);
		LOCATION.mkdirs();
	}
	
}
