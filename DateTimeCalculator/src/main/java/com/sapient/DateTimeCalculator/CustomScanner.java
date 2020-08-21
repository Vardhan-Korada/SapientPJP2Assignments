package com.sapient.DateTimeCalculator;

import java.util.Scanner;

public class CustomScanner {
	public Scanner sc;
	public CustomScanner() {
		sc = new Scanner(System.in);
	}
	public int getInteger() {
		return Integer.parseInt(sc.nextLine());
	}
	public String getString() {
		return sc.nextLine();
		
	}
	public String getLine() {
		return sc.nextLine();
	}
	protected void finalize() {
		sc.close();
	}
}
