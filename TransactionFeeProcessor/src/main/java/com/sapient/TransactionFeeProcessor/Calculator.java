package com.sapient.TransactionFeeProcessor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Calculator {
	private List<Transaction> transactionList = new ArrayList<>();
	private static BufferedWriter fileWriter;

	public void addTransactionList(List<Transaction> transactions) {
		for (Transaction transaction : transactions) {
			transactionList.add(calculateFee(transaction));
		}
	}

	private Transaction calculateFee(Transaction transaction) {
		if (isIntradayTransaction(transaction)) {
			transaction.setTransactionFees(GlobalConstants.TRANSACTION_FEE.TEN.getFees());
		} else {
			if (transaction.getPriority()) {
				transaction.setTransactionFees(GlobalConstants.TRANSACTION_FEE.FIVE_HUNDRED.getFees());
			} else {
				if (transaction.getTransactionType() == GlobalConstants.TRANSACTION_TYPE.SELL.getType()
						|| transaction.getTransactionType() == GlobalConstants.TRANSACTION_TYPE.WITHDRAW.getType()) {
					transaction.setTransactionFees(GlobalConstants.TRANSACTION_FEE.HUNDRED.getFees());
				} else if (transaction.getTransactionType() == GlobalConstants.TRANSACTION_TYPE.BUY.getType()
						|| transaction.getTransactionType() == GlobalConstants.TRANSACTION_TYPE.DEPOSIT.getType()) {
					transaction.setTransactionFees(GlobalConstants.TRANSACTION_FEE.FIFTY.getFees());
				}
			}
		}
		return transaction;
	}

	private boolean isIntradayTransaction(Transaction transaction) {
		boolean isIntraDayTransaction = false;
		for (Transaction entry : transactionList) {
			if (entry.getClientId().equals(transaction.getClientId())
					&& entry.getSecurityId().equals(transaction.getSecurityId())
					&& entry.getTransactionDate().equals(transaction.getTransactionDate())) {
				if ((entry.getTransactionType() == GlobalConstants.TRANSACTION_TYPE.BUY.getType()
						&& transaction.getTransactionType() == GlobalConstants.TRANSACTION_TYPE.SELL.getType())
						|| (entry.getTransactionType() == GlobalConstants.TRANSACTION_TYPE.SELL.getType() && transaction
								.getTransactionType() == GlobalConstants.TRANSACTION_TYPE.BUY.getType())) {
					isIntraDayTransaction = true;
					break;
				}
			}
		}
		return isIntraDayTransaction;
	}

	public void generateTransactionFeeReport() {
		transactionList
				.sort(Comparator.comparing(Transaction::getClientId).thenComparing(Transaction::getTransactionType)
						.thenComparing(Transaction::getTransactionDate).thenComparing(Transaction::getPriority));
		String msg = "Client Id,Transaction Type,Transaction Date,Priority,Processing Fee";
		try {
			fileWriter = new BufferedWriter(new FileWriter(GlobalConstants.OUTPUT_FILE));
			fileWriter.write(msg);
			fileWriter.newLine();
			for (Transaction transaction : transactionList) {
				fileWriter.write(
						transaction.getClientId() + "," + HelperClass.getTypeName(transaction.getTransactionType())
								+ "," + transaction.getTransactionDate() + ","
								+ (transaction.getPriority() ? "HIGH," : "NORMAL,") + transaction.getTransactionFees());
				fileWriter.newLine();
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
