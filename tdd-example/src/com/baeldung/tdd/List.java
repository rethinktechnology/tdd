package com.baeldung.tdd;

public interface List<E> {

	boolean isEmpty();

	boolean add(E e);

	int size();
	
	E get(int index);

}
