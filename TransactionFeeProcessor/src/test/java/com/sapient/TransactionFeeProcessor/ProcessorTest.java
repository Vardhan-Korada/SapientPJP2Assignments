package com.sapient.TransactionFeeProcessor;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProcessorTest {

	@Test
	public void test() {
		assertTrue(ProcessorEngine.process());
	}

}
