package com.sapient.DateTimeCalculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class CustomScannerTest {

	CustomScanner cs;

	@Before
	public void setup() {
		cs = new CustomScanner();
	}

	@Test
	public void integerTest() {
		System.out.println("Enter any integer: ");
		assertEquals(2, cs.getInteger());
	}

	@Test
	public void consecutiveIntegerTest() {
		System.out.println("Enter first integer: ");
		assertEquals(1, cs.getInteger());
		System.out.println("Enter second integer: ");
		assertEquals(2, cs.getInteger());
		System.out.println("Enter second integer: ");
		assertEquals(3, cs.getInteger());
	}

	@Test
	public void stringTest() {
		System.out.println("Enter any String: ");
		assertEquals("Hello", cs.getString());
	}

	@Test
	public void consecutiveStringTest() {
		System.out.println("Enter first String: ");
		assertEquals("Hello", cs.getString());
		System.out.println("Enter second String: ");
		assertEquals("World", cs.getString());
	}

	@Test
	public void integerPlusStringTest() {
		System.out.println("Enter any integer: ");
		assertEquals(2, cs.getInteger());
		System.out.println("Enter any String: ");
		assertEquals("Hello", cs.getString());
		System.out.println("Enter any integer: ");
		assertEquals(2, cs.getInteger());
		System.out.println("Enter any String: ");
		assertEquals("Hello", cs.getString());
	}

	@Test
	public void lineTest() {
		System.out.println("Enter a line: ");
		assertEquals("Hello World", cs.getLine());
	}

	@Test
	public void consecutiveLineTest() {
		System.out.println("Enter first line: ");
		assertEquals("Hello World", cs.getLine());
		System.out.println("Ënter second line: ");
		assertEquals("Hello Again", cs.getLine());
	}

	@Test
	public void consecutiveIntegerLineTest() {
		System.out.println("Enter an Integer: ");
		assertEquals(2, cs.getInteger());
		System.out.println("Ënter a line: ");
		assertEquals("Hello Again", cs.getLine());
	}

	@Test
	public void consecutiveStringLineTest() {
		System.out.println("Enter a String: ");
		assertEquals("Hello", cs.getString());
		System.out.println("Ënter a line: ");
		assertEquals("Hello Again", cs.getLine());
	}
	
	@Test
	public void consecutiveIntegerStringLineTest() {
		System.out.println("Enter an Integer: ");
		assertEquals(2, cs.getInteger());
		System.out.println("Enter a String: ");
		assertEquals("Hello", cs.getString());
		System.out.println("Ënter a line: ");
		assertEquals("Hello Again", cs.getLine());
	}
}
