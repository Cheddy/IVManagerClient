package com.csoftware.ivmanager.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OutputPrinter implements Printable {
	private String text;
	public final String HEADER;
	public final String FOOTER;

	private Graphics2D g2d;
	private FontMetrics metrics;
	private int fontHeight;
	private int fontDescent;
	private double pageHeight;
	private double pageWidth;
	private int lineHeight;
	private int linesPerPage;
	private int bodyLinesPerPage;
	private int numberOfPages;
	private int currentY;

	public OutputPrinter(String printDataIn, String name) {
		this.text = printDataIn;
		HEADER = "Morecambe Bay Hospitals Pharmacy Department" + System.lineSeparator() + "Intervention Record - " + name + System.lineSeparator() + System.lineSeparator();
		LocalDateTime date = LocalDateTime.now();
		String RefactoredDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		FOOTER = "Correct as of: " + RefactoredDate;
	}

	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
		g2d = (Graphics2D) g;
		int x = (int) pf.getImageableX();
		int y = (int) pf.getImageableY();
		g2d.translate(x, y);

		setFont(new Font("Calibri", Font.PLAIN, 14), g, pf);
		ArrayList<String> lines = getLines(text);

		setFont(new Font("Calibri", Font.BOLD, 14), g, pf);
		ArrayList<String> foot = getLines(FOOTER);
		ArrayList<String> head = getLines(HEADER);
		int drawable = (int) ((pageHeight - 72 - 72 - ((head.size() + foot.size()) * lineHeight)));
		setFont(new Font("Calibri", Font.PLAIN, 14), g, pf);
		linesPerPage = (drawable / lineHeight) - 1;
		bodyLinesPerPage = linesPerPage;

		numberOfPages = (int) Math.ceil((double) lines.size() / bodyLinesPerPage);

		if (page >= numberOfPages) {
			return Printable.NO_SUCH_PAGE;
		}

		setFont(new Font("Calibri", Font.BOLD, 14), g, pf);
		currentY = lineHeight;
		drawCentredSection(head);

		setFont(new Font("Calibri", Font.PLAIN, 14), g, pf);
		drawPageSection(lines, page);

		setFont(new Font("Calibri", Font.BOLD, 14), g, pf);
		currentY = (int) ((pageHeight - 72 - 72) - lineHeight * foot.size());
		drawCentredSection(foot);
		return Printable.PAGE_EXISTS;
	}

	public void drawPageSection(ArrayList<String> lines, int page) {
		int currentX = 0;
		for (int i = page * linesPerPage; i < linesPerPage * (page + 1); i++) {
			if (i >= lines.size()) {
				return;
			} else {
				String line = lines.get(i);
				g2d.drawString(line, currentX, currentY);
				currentY += lineHeight;
			}
		}
	}

	public void drawCentredSection(ArrayList<String> lines) {
		for (String line : lines) {
			int currentX = (int) ((pageWidth / 2.00) - (metrics.stringWidth(line) / 2.00));
			g2d.drawString(line, currentX, currentY);
			currentY += lineHeight;
		}
	}

	public ArrayList<String> getLines(String text) {
		ArrayList<String> lines = new ArrayList<>();
		final String nullChar = new String(new char[] {
			'\0'
		});
		text = text.replace(System.lineSeparator(), nullChar + System.lineSeparator());
		String[] words = text.split(" |" + System.lineSeparator());
		String currLine = words[0];
		boolean newL = false;
		for (int i = 1; i < words.length; i++) {
			String word = words[i].replace("\t", "    ");
			String newLine = currLine + " " + word;
			if (newL || metrics.stringWidth(newLine) > pageWidth) {
				lines.add(currLine);
				if (currLine.startsWith("    ") && !word.startsWith(">")) {
					word = "    " + word;
				}
				currLine = word;
			} else {
				currLine = newLine;
			}
			if (words[i].contains(nullChar)) {
				newL = true;
			} else {
				newL = false;
			}
		}
		lines.add(currLine);
		return lines;
	}

	public void setFont(Font font, Graphics g, PageFormat pf) {
		g2d.setFont(font);
		g2d.setColor(Color.black);

		metrics = g.getFontMetrics(font);
		fontHeight = g2d.getFontMetrics().getHeight();
		fontDescent = g2d.getFontMetrics().getDescent();

		lineHeight = fontHeight + fontDescent;

		pageHeight = pf.getHeight();
		pageWidth = pf.getImageableWidth();
	}
}