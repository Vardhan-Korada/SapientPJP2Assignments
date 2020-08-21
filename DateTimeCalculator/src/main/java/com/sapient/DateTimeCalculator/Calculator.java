package com.sapient.DateTimeCalculator;

public class Calculator {
	private static String result;
	public static void main(String[] args) {
		Menu m = new Menu();
		Operations op = new Operations();
		Result res = new Result();
		m.displayInput();
		m.getInput();
		result = op.performOperation(m.getInputString(),m.getChoice());
		res.displayResult(result);
	}
}
