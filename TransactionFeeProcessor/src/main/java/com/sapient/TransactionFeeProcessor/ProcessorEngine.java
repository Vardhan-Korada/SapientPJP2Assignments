package com.sapient.TransactionFeeProcessor;
import java.util.List;

import com.sapient.TransactionFeeProcessor.GlobalConstants.FILE_TYPE;

public class ProcessorEngine {
	public static boolean process(){
		System.out.println("Reading the transaction file....");
		TransactionReader.readFile(FILE_TYPE.CSV);
		List<Transaction> transactions = TransactionReader.getTransactionList();
        Calculator calculator = new Calculator();
        calculator.addTransactionList(transactions);
        System.out.println("Generating the transaction fee report...");
        calculator.generateTransactionFeeReport();
        System.out.println("Report Generated");
        return true;
	}
}
