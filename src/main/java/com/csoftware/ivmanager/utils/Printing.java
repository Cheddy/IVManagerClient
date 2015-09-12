package com.csoftware.ivmanager.utils;

import com.csoftware.ivmanager.model.CompleteIntervention;
import com.csoftware.ivmanager.model.InterventionDetail;

import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.Sides;
import java.awt.print.PrinterJob;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Printing {

	public static boolean print(String text, String name) {
		try {
			HashPrintRequestAttributeSet atrr = new HashPrintRequestAttributeSet();
			if (PrintServiceLookup.lookupDefaultPrintService().isAttributeValueSupported(Sides.DUPLEX, null, null)) {
				atrr.add(Sides.DUPLEX);
			}
			atrr.add(OrientationRequested.PORTRAIT);
			atrr.add(new JobName(String.valueOf("Intervention Record"), new Locale("en")));

			PrinterJob job = PrinterJob.getPrinterJob();
			
			job.setPrintable(new OutputPrinter(text, name));
			boolean pf = job.printDialog(atrr);
			if(pf){
				job.print();
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean print(CompleteIntervention record) {
		if (record == null) {
			return false;
		}
		String s = "";
		s += "Patient Name: " + record.getPatient().getOthernames() + " " + record.getPatient().getSurname() + System.lineSeparator();
		s += "RTX Number: " + record.getPatient().getRtx() + System.lineSeparator();
		s += "Date of Birth: " + record.getPatient().getDob().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + System.lineSeparator();
		s += "Ward: " + record.getWard().getName() + System.lineSeparator();
		s += "Date/Time: " + record.getDateTime().toString("dd/MM/yyyy HH:mm") + System.lineSeparator();
		s += "Details: " + System.lineSeparator();
		for (InterventionDetail item : record.getDetails()) {
			s += ">" + item.getDescription() + ":" + System.lineSeparator();
			s += "\t" + item.getDetail().replace(System.lineSeparator(), System.lineSeparator() + "\t") + System.lineSeparator();
		}
		return print(s, record.getPatient().getOthernames() + " " + record.getPatient().getSurname());
	}

}
