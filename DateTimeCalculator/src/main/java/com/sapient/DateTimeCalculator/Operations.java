package com.sapient.DateTimeCalculator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import com.joestelmach.natty.*;

public class Operations {

	private String result;
	private DateTimeFormatter formatter;

	public Operations() {
		this.formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.US);
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String performOperation(String input, int choice) {
		switch (choice) {
		case 1: {
			this.result = naturalLanguageProcessor(input);
			break;
		}
		case 2: {
			this.result = getDayOfWeek(input);
			break;
		}
		case 3: {
			this.result = getWeekNumber(input);
			break;
		}
		case 4: {
			this.result = addTimeToDate(input);
			break;
		}
		case 5: {
			this.result = delTimeFromDate(input);
			break;
		}
		case 6: {
			addTwoDates(input);
			break;
		}
		case 7: {
			this.result = delTwoDates(input);
			break;
		}
		default: {
			System.out.println("Will Never Be Invoked");
		}
		}
		return this.result;
	}

	private String delTwoDates(String input) {
		String[] arr = input.split(" minus ");
		LocalDate startLocalDate = LocalDate.parse(arr[0], formatter);
		LocalDate endLocalDate = LocalDate.parse(arr[1], formatter);
		Period diff = Period.between(startLocalDate, endLocalDate);
		return String.format("%d years, %d months" + " and %d days", diff.getYears(), diff.getMonths(),
				diff.getDays());
	}

	private void addTwoDates(String input) {
		System.out.println("Not Possible without reference...");
	}

	private String delTimeFromDate(String input) {
		String[] arr = input.split(" minus ");
		LocalDate localDate = LocalDate.parse(arr[0], formatter);
		String[] addPeriod = arr[1].split(",");
		ArrayList<String> yearsMonthsDays = new ArrayList<String>();
		for (String str : addPeriod) {
			yearsMonthsDays.add(str.split(" ")[0]);
		}
		LocalDate newDate = localDate.minusYears(Long.parseLong(yearsMonthsDays.get(0)))
				.minusMonths(Long.parseLong(yearsMonthsDays.get(1))).minusDays(Long.parseLong(yearsMonthsDays.get(2)));
		return newDate.toString();
	}

	private String addTimeToDate(String input) {
		String[] arr = input.split(" plus ");
		LocalDate localDate = LocalDate.parse(arr[0], formatter);
		String[] addPeriod = arr[1].split(",");
		ArrayList<String> yearsMonthsDays = new ArrayList<String>();
		for (String str : addPeriod) {
			yearsMonthsDays.add(str.split(" ")[0]);
		}
		LocalDate newDate = localDate.plusYears(Long.parseLong(yearsMonthsDays.get(0)))
				.plusMonths(Long.parseLong(yearsMonthsDays.get(1))).plusDays(Long.parseLong(yearsMonthsDays.get(2)));
		return newDate.toString();
	}

	private String getWeekNumber(String input) {
		LocalDate localDate = LocalDate.parse(input, formatter);
		return String.valueOf(localDate.get(WeekFields.of(Locale.US).weekOfYear()));

	}

	private String getDayOfWeek(String input) {
		LocalDate localDate = LocalDate.parse(input, formatter);
		DayOfWeek day = localDate.getDayOfWeek();
		return day.getDisplayName(TextStyle.FULL, Locale.US);
	}

	private String naturalLanguageProcessor(String input) {
		Parser parser = new Parser();
		List<DateGroup> parse = parser.parse(input);
		return parse.get(0).getDates().get(0).toString();
	}

}
