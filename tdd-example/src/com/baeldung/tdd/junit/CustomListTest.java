package com.baeldung.tdd.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.baeldung.tdd.CustomList;
import com.baeldung.tdd.List;

class CustomListTest {

	@Test
	public void givenEmptyList_whenIsEmpty_thenTrueIsReturned() {
		List<Object> list = new CustomList<>();
		assertTrue(list.isEmpty());
	}

	@Test
	public void givenNonEmptyList_whenIsEmpty_thenFalseIsReturned() {
		List<Object> list = new CustomList<>();
		list.add(null);
		assertFalse(list.isEmpty());
	}

	@Test
	public void givenListWithAnElement_whenSize_thenOneIsReturned() {
		List<Object> list = new CustomList<>();
		list.add(null);
		assertEquals(1, list.size());
	}

	@Test
	public void givenListWithAnElement_whenGet_thenThatElementIsReturned() {
		List<String> list = new CustomList<>();
		list.add("person");
		String person = list.get(0);
		assertEquals("person", person);
	}

	@Test
	public void givenEmptyList_whenElementIsAdded_thenGetReturnsThatElement() {
		List<Object> list = new CustomList<>();
		boolean succeeded = list.add(null);
		assertTrue(succeeded);
	}

	@Test
	public void givenListWithAnElement_whenAnotherIsAdded_thenGetReturnsBoth() {
		List<Object> list = new CustomList<>();
		list.add("TDD");

		list.add("Agile");

		Object first = list.get(0);
		Object second = list.get(1);
		assertEquals("TDD", first);
		assertEquals("Agile", second);
	}

}
