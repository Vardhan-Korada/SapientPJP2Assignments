package com.sapient.TransactionFeeProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.TransactionFeeProcessor.GlobalConstants.FILE_TYPE;

public class TransactionReader {
	private static List<Transaction> transactionList = new ArrayList<>();
	private static BufferedReader fileReader;

	public static List<Transaction> getTransactionList() {
		return transactionList;
	}

	public static List<Transaction> readFile(FILE_TYPE fileType) {
		switch (fileType) {
		case CSV: {
			return TransactionReader.readCSVFile();
		}
		default: {
			System.out.println("Cannot read this file type yet");
			return null;
		}
		}
	}

	private static List<Transaction> readCSVFile() {
		try {
			fileReader = new BufferedReader(new FileReader(GlobalConstants.INPUT_FILE));
			String data = "";
			while ((data = fileReader.readLine()) != null) {
				String[] transactionAttributes = data.split(",");
				Transaction transaction = HelperClass.getTransaction(transactionAttributes);
				transactionList.add(transaction);
			}
			return getTransactionList();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
