package com.speakerdeck;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EuroTest {
	@Test
	void testEuroString() throws Exception {
		assertEquals("EURO 2.00", new Euro(2).toString());
		assertEquals("EURO 7.50", new Euro(7.50).toString());
	}
	
	@Test
	void testEquality() throws Exception {
		Euro twoEuro = new Euro(2);
		Euro twoEuroToo = new Euro(2);
		assertTrue(twoEuro.equals(twoEuroToo));
	}
	
	@Test
	void testInEquality() throws Exception {
		Euro twoEuro = new Euro(2);
		Euro threeEuro = new Euro(3);
		assertFalse(twoEuro.equals(threeEuro));
	}
	
	@Test
	void testEuroSubtract() throws Exception {
		assertEquals(new Euro(2), new Euro(3).minus(new Euro(1)));
		assertEquals(new Euro(1), new Euro(2).minus(new Euro(1)));
	}
	
	@Test
	void testNumericSafety() throws Exception {
		assertEquals(new Euro(0.61), new Euro(1.03).minus(new Euro(0.42)));
	}
	
}
