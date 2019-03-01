package com.baeldung.tdd;

import java.util.Arrays;

public class CustomList<E> implements List<E> {

	private Object[] internal = {};

	@Override
	public boolean isEmpty() {
		return internal.length == 0;
	}

	@Override
	public boolean add(E e) {
		Object[] temp = Arrays.copyOf(internal, internal.length + 1);
		temp[internal.length] = e;
		internal = temp;
		return true;
	}

	@Override
	public int size() {
		return internal.length;
	}

	@Override
	public E get(int index) {
		return (E) internal[index];
	}
}
