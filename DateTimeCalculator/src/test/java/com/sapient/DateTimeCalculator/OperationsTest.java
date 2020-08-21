package com.sapient.DateTimeCalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OperationsTest {

//	private Menu m;
//	@Rule
//	public MockitoRule rule = MockitoJUnit.rule();
//	@Mock
	private Operations op;

	@Before
	public void setup() {
//		m = new Menu();
		op = new Operations();
	}

//	@Test
//	public void simpleInvokeTest() {
//		m.displayInput();
//		m.getInput();
//		when(op.performOperation(anyString(), anyInt())).thenReturn("85");
//		assertEquals("85",op.performOperation(m.getInputString(),6));
//		verify(op,times(1)).performOperation(anyString(),anyInt());
//	}

	@Test
	public void testDayOfTheWeek() {
		op.performOperation("23-02-1999", 2);
		assertEquals("Tuesday", op.getResult());
	}

	@Test
	public void testWeekNumber() {
		op.performOperation("01-01-2000", 3);
		assertEquals("1", op.getResult());
	}

	@Test
	public void testNaturalLanguageProcessor() {
		op.performOperation("Today", 1);
		assertTrue(op.getResult().contains("IST"));
	}

	@Test
	public void testDeleteTime() {
		op.performOperation("23-02-1999 minus 5 years,6 months,8 days", 5);
		assertEquals("1993-08-15", op.getResult());
	}

	@Test
	public void testAddTime() {
		op.performOperation("23-02-1999 plus 5 years,6 months,8 days", 4);
		assertEquals("2004-08-31", op.getResult());
	}

	@Test
	public void testSubTwoDates() {
		op.performOperation("23-02-1999 minus 25-06-2005", 7);
		assertEquals("6 years, 4 months and 2 days", op.getResult());
	}
}
