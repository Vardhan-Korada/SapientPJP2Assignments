package com.sapient.DateTimeCalculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class MenuTest {
	Menu m;
	
	@Before
	public void setup() {
		m = new Menu();
	}

	@Test
	public void basicMenuDisplay() {
		m.displayInput();
		assertEquals(6,m.getChoice());
	}

	@Test
	public void correctSubMenuDisplayOption1() {
		m.displayInput();
		assertEquals(1, m.getChoice());
		m.getInput();
		assertEquals("Today",m.getInputString());
		assertEquals(1,m.getChoice());
		m.getInput();
		assertEquals("After 5 days",m.getInputString());
	}
	@Test
	public void correctSubMenuDisplayOption2() {
		m.displayInput();
		assertEquals(2,m.getChoice());
		m.getInput();
		assertEquals("23-02-1999",m.getInputString());
	}
	@Test
	public void correctSubMenuDisplayOption3() {
		m.displayInput();
		assertEquals(3, m.getChoice());
		m.getInput();
		assertEquals("23-02-1999",m.getInputString());
	}
	@Test
	public void correctSubMenuDisplayOption4() {
		m.displayInput();
		assertEquals(4, m.getChoice());
		m.getInput();
		assertEquals("23-02-1999 plus 5 days,6 hours,30 minutes",m.getInputString());
	}
	@Test
	public void correctSubMenuDisplayOption5() {
		m.displayInput();
		assertEquals(5,m.getChoice());
		m.getInput();
		assertEquals("23-02-1999 minus 5 days,6 hours,30 minutes",m.getInputString());
	}
	@Test
	public void correctSubMenuDisplayOption6() {
		m.displayInput();
		assertEquals(6, m.getChoice());
		m.getInput();
		assertEquals("23-02-1999 plus 24-02-2000",m.getInputString());
	}
	@Test
	public void correctSubMenuDisplayOption7() {
		m.displayInput();
		assertEquals(7, m.getChoice());
		m.getInput();
		assertEquals("23-02-1999 minus 24-02-2000",m.getInputString());
	}
	@Test
	public void invalidOptionChoosing() {
		m.displayInput();
		m.getInput();
		assertEquals("Invalid",m.getInputString());
	}
}
