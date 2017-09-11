package mx.jzab.edu.tdd;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public class ToatzinPadillaMap<K, V> implements Map<K, V> {
	
	private int size = 0;
	private ArrayList<Entry<K,V>> table = new ArrayList<Entry<K,V>>();

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		table.clear();
	}

	@Override
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		if(isEmpty()) return false;
		for (Entry<K,V> e : table) {
//			   System.out.println("Key: " + e.getKey());
			   if(e.getKey().equals(key)) return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(V value) {
		// TODO Auto-generated method stub
		if(isEmpty()) return false;
		for (Entry<K,V> e : table) {
//			   System.out.println("Value: " + e.getValue());
			   if(e.getValue().equals(value)) return true;
		}
		return false;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		for (Entry<K,V> e : table) {
			   if(e.getKey().equals(key)) return e.getValue();
		}
		return null;
	}

	@Override
	public V getOrDefault(K key, V defaultValue) {
		// TODO Auto-generated method stub
		if(isEmpty()) return defaultValue;
		for (Entry<K,V> e : table) {
			   if(e.getKey().equals(key)) return e.getValue();
		}
		return defaultValue;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
//		System.out.println("SIZE: " + size);
		return this.size == 0;
	}

	@Override
	public void put(K key, V value) {
		// TODO Auto-generated method stub
		if(key == null){
			throw new Error("Forbidden null key");
		}
		for (Entry<K,V> e : table) {
//			   System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
			   if(e.getKey().equals(key)){
				   e.setValue(value);
				   return;
			   }
		}
		table.add(new AbstractMap.SimpleEntry<K,V>(key,value));
		size++;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		for (int i = 0; i < table.size(); i++) {
			Entry<K,V> e = table.get(i);
			if(e.getKey().equals(key)){
				   table.remove(i);
				   size--;
				   return e.getValue();
			   }
		}
		return null;
	}

	@Override
	public void replace(K key, V value) throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(key == null){
			throw new Error("Forbidden null keys");
		}
		for (Entry<K,V> e : table) {
//			   System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
			   if(e.getKey().equals(key)){
				   e.setValue(value);
				   return;
			   }
		}
		throw new NoSuchElementException();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return (Collection<V>) table;
	}

}
