package uke10.strings;

import java.util.Iterator;

public class StringIterator implements Iterator<Character>{

	private final String s;
	private int pos = 0;
	
	@Override
	public boolean hasNext() {
		return pos < s.length();
	}

	@Override
	public Character next() {
		char next = s.charAt(pos);
		pos = pos + 1;
		return next;
	}
	
	public StringIterator(String s) {
		super();
		this.s = s;
	}
	
}
