package chapterVII_technicalQuestions;

import java.util.Hashtable;

public class HashTables<T, E> {
	
	Hashtable<T, E> ht;
	
	public HashTables() {
		ht = new Hashtable<T, E>();
	}
	
	public void clear() {
		ht.clear();
	}
	
	public boolean contains(E value) {
		return ht.contains(value);
	}
	
	public boolean containsKey(T key) {
		return ht.containsKey(key);
	}
	
	public E put(T key, E value) {
		return ht.put(key, value);
	}
	
	public E remove(T key) {
		return ht.remove(key);
	}
	
	public boolean isEmpty() {
		return ht.isEmpty();
	}
	
	public E replace(T key, E value) {
		return (E) ht.replace(key, value);
	}

}
