package com.csoftware.ivmanager.data;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;

import javafx.scene.image.Image;

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
	
	public static final int VIEW_HOSPITAL_PERMISSION = 1;
	public static final int EDIT_HOSPITAL_PERMISSION = 2;
	public static final int DELETE_HOSPITAL_PERMISSION = 4;

	public static final int VIEW_IMPACT_PERMISSION = 8;
	public static final int EDIT_IMPACT_PERMISSION = 16;
	public static final int DELETE_IMPACT_PERMISSION = 32;
	
	public static final int VIEW_STAFF_RANK_PERMISSION = 64;
	public static final int EDIT_STAFF_RANK_PERMISSION = 128;
	public static final int DELETE_STAFF_RANK_PERMISSION = 256;
	
	public static final int VIEW_PATIENT_PERMISSION = 512;
	public static final int EDIT_PATIENT_PERMISSION = 1024;
	public static final int DELETE_PATIENT_PERMISSION = 2048;
	
	public static final int VIEW_STAFF_PERMISSION = 4096;
	public static final int EDIT_STAFF_PERMISSION = 8192;
	public static final int DELETE_STAFF_PERMISSION = 16384;
	
	public static final int UNASSIGNED_ID = -1;
	
	public static int serverIP = 7;
	public static final int userPermissions = 0b1111111111111111;

	
	static {
		try {
			LOGO = new Image(ClassLoader.getSystemResource("resources/logo.png").toString());
		} catch (Exception e) {
			throw new RuntimeException("Could Not Load Logo!");
		}
		TABLE_FILE.setReadable(true, false);
		TABLE_FILE.setExecutable(true, false);
		TABLE_FILE.setWritable(true, false);
		System.out.println(TABLE_FILE.getAbsolutePath());
		LOCATION.mkdirs();
	}
	
}
