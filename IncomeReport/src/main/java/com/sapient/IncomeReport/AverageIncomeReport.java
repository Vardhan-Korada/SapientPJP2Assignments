package com.sapient.IncomeReport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AverageIncomeReport {

	public static String IN_FILE_LOCATION = "D:\\PJP2\\input.csv";
	public static String OUT_FILE_LOCATION = "D:\\PJP2\\output.csv";

	public static String CURRENCY_CODE_IND = "INR";
	public static String CURRENCY_CODE_GBP = "GBP";
	public static String CURRENCY_CODE_SGD = "SGP";
	public static String CURRENCY_CODE_HKD = "HKD";
	public static String CURRENCY_CODE_USD = "USD";

	public static String DELIMETER_PIPE = "|";
	public static String DELIMETER_COMMA = ",";
	public static String DELIMETER_WHITE_SPACE = " ";

	public static String FILE_CSV = ",";
	public static String FILE_TXT = "";

	public static BufferedWriter fileWriter;
	public static BufferedReader fileReader;

	public static Map<String, Float> countryMap;

	public static void main(String[] args) {
		try {
			System.out.println("Calculating Average Income...");
			averageIncome();
			System.out.println("Country Map: ");
			for (Map.Entry<String, Float> ms : countryMap.entrySet()) {
				System.out.print(ms.getKey());
				System.out.println(" "+ms.getValue());
			}
			System.out.println("Writing the output file...");
			writeToFile(AverageIncomeReport.FILE_CSV);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void averageIncome() throws IOException {
		countryMap = new HashMap<String, Float>();
		try {
			fileReader = new BufferedReader(new FileReader(AverageIncomeReport.IN_FILE_LOCATION));
			fileReader.readLine();
			String data = "";
			while ((data = fileReader.readLine()) != null) {
				String[] s = data.split(AverageIncomeReport.DELIMETER_COMMA);
				String city = s[0];
				String country = s[1];
				String gender = s[2];
				String currency = s[3];
				int averageIncome = Integer.parseInt(s[4]);
				float convertedAvgIncome = avgIncome(currency, averageIncome);
				if (country.equals(" ")) {
					if (countryMap.containsKey(city + "," + gender)) {
						float avg = countryMap.get(city + "," + gender);
						avg += convertedAvgIncome;
						countryMap.put(city + "," + gender, avg);
					} else {
						countryMap.put(city + "," + gender, convertedAvgIncome);
					}
				} else {
					if (countryMap.containsKey(country + "," + gender)) {
						float avg = countryMap.get(country + "," + gender);
						avg += convertedAvgIncome;
						countryMap.put(country + "," + gender, avg);
					} else {
						countryMap.put(country + "," + gender, convertedAvgIncome);
					}
				}
			}
			Collections.sort(new ArrayList<>(countryMap.keySet()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static float avgIncome(String currency, int averageIncome) {
		float convertedAvgIncome = 0.0f;
		if (currency.equals(AverageIncomeReport.CURRENCY_CODE_IND)) {
			convertedAvgIncome = averageIncome / 66;
		} else if (currency.equals(AverageIncomeReport.CURRENCY_CODE_GBP)) {
			convertedAvgIncome = (float) (averageIncome / 0.67);
		} else if (currency.equals(AverageIncomeReport.CURRENCY_CODE_SGD)) {
			convertedAvgIncome = (float) (averageIncome / 1.5);
		} else if (currency.equals(AverageIncomeReport.CURRENCY_CODE_HKD)) {
			convertedAvgIncome = averageIncome / 8;
		} else if (currency.equals(AverageIncomeReport.CURRENCY_CODE_USD)) {
			convertedAvgIncome = averageIncome;
		}
		return convertedAvgIncome;
	}

	private static void writeToFile(String fileType) throws IOException {
		String msg = "City/Country,Gender,Average Income(in USD)";
		fileWriter = new BufferedWriter(new FileWriter(AverageIncomeReport.OUT_FILE_LOCATION));
		fileWriter.write(msg);
		fileWriter.newLine();
		for (Map.Entry<String, Float> ms : countryMap.entrySet()) {
			String key = ms.getKey();
			float value = ms.getValue();
			String countryGen[] = key.split(AverageIncomeReport.DELIMETER_COMMA);
			String record = countryGen[0] + " " + countryGen[1] + " " + value;
			if (fileType.equals(AverageIncomeReport.FILE_CSV)) {
				fileWriter.write(key + AverageIncomeReport.DELIMETER_COMMA + value);
			} else {
				fileWriter.write(record);
			}
			fileWriter.newLine();
		}
		fileWriter.close();
	}
}
