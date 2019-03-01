package com.osherove;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	StringCalculator calc = new StringCalculator();

	@Test
	void testAdd_withEmptyString() throws Exception {
		assertEquals(0, calc.add(""));
	}

	@Test
	void testAdd_withOneNumber() throws Exception {
		assertEquals(1, calc.add("1"));
	}
	
	@Test
	void testAdd_withTwoNumbers() throws Exception {
		assertEquals(3, calc.add("1,2"));
	}
	
	@Test
	void testAdd_withMoreThanTwoNumbers() throws Exception {
		assertEquals(10, calc.add("1,2,3,4"));
	}
	
	@Test
	void testAdd_withNewLineAndNumbers() throws Exception {
		assertEquals(6, calc.add("1\n2,3"));
	}
	
	@Test
	void testFindDelimiter_byDefaultOne() throws Exception {
		assertEquals("\\,", calc.findDelimiter("1,2"));
	}
	
	@Test
	void testFindDelimiter_byNewLineOne() throws Exception {
		assertEquals("\\,|\\n", calc.findDelimiter("1,2\n3"));
	}
	
	@Test
	void testFindDelimiter_byCustomOne() throws Exception {
		assertEquals("\\n|;", calc.findDelimiter("//;\n1;2\n3"));
	}
	
	@Test
	void testValidateFormat_beginByDoubleForwardSlashOnly() throws Exception {
		assertFalse(calc.validateFormat("//;1;3"));
	}
	
	@Test
	void testValidateFormat_withDelimiterAndNewLine_ButNoDoubleForwardSlash() throws Exception {
		assertFalse(calc.validateFormat(";\n1;3"));
	}
	
	@Test
	void testValidateFormat_byDoubleForwardSlashAndNewLineFollowedByDelimiter() throws Exception {
		assertTrue(calc.validateFormat("//;\n2;3;4"));
	}
	
	@Test
	void testExtractDelimiter_correctDelimiter() throws Exception {
		assertEquals(';', calc.extractDelimiter("//;\n2;3"));
	}
	
	@Test
	void testExtractDelimiter_incorrectDelimiter() throws Exception {
		assertNotEquals(";", calc.extractDelimiter("//|\n2;3"));
	}
	
	@org.junit.Test(expected=InvalidDelimiterFormat.class)
	void testExtractDelimiter_invalidForm_expectException() throws Exception {
		assertEquals(";", calc.extractDelimiter("//\n2,3"));
	}

	@Test
	void testAdd_withCustomDelimitedNumberString() throws Exception {
		assertEquals(9, calc.add("//;\n2;3;4"));
	}
	
}
