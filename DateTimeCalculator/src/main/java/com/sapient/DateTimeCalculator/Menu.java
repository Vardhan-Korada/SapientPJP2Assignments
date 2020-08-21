package com.sapient.DateTimeCalculator;

public class Menu {
	private CustomScanner cs;
	private String inputString;
	private int choice;

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public String getInputString() {
		return inputString;
	}

	public Menu() {
		cs = new CustomScanner();
	}

	public void displayInput() {
		System.out.println("Select a option from the following: ");
		System.out.println("1. Translate Natural Language");
		System.out.println("2. Get Day of the Week");
		System.out.println("3. Get the Week Number");
		System.out.println("4. Add time to given date");
		System.out.println("5. Delete time from given date");
		System.out.println("6. Add two dates");
		System.out.println("7. Subtract two dates");
		System.out.print("Enter your choice: ");
		this.choice = cs.getInteger();
	}

	public void getInput() {
		switch (choice) {
		case 1: {
			System.out.println("Enter your query: ");
			inputString = cs.getLine();
			break;
		}
		case 2: {
			System.out.println("Enter date in the format dd-mm-yyyy: ");
			inputString = cs.getString();
			break;
		}
		case 3: {
			System.out.println("Enter date in the format dd-mm-yyyy: ");
			inputString = cs.getString();
			break;
		}
		case 4: {
			System.out.println("Enter date in the format dd-mm-yyyy: ");
			inputString = cs.getString();
			System.out.println("Enter amount of time to be added to the date in the comma seperated format: ");
			String s = cs.getLine();
			inputString += " plus " + s;
			break;
		}
		case 5: {
			System.out.println("Enter date in the format dd-mm-yyyy: ");
			inputString = cs.getString();
			System.out.println("Enter amount of time to be subtracted from the date in the comma seperated format: ");
			String s = cs.getLine();
			inputString += " minus " + s;
			break;
		}
		case 6: {
			System.out.println("Give the first date in the format dd-mm-yyyy: ");
			String s1 = cs.getString();
			System.out.println("Give the second date in the format dd-mm-yyyy: ");
			String s2 = cs.getString();
			inputString = s1 + " plus " + s2;
			break;
		}
		case 7: {
			System.out.println("Give the first date in the format dd-mm-yyyy: ");
			String s1 = cs.getString();
			System.out.println("Give the second date in the format dd-mm-yyyy: ");
			String s2 = cs.getString();
			inputString = s1 + " minus " + s2;
			break;
		}
		default: {
			System.out.println("Invalid Option....");
			inputString = "Invalid";
		}
		}
	}

}
