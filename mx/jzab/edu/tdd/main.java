package mx.jzab.edu.tdd;

import java.util.Collection;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ToatzinPadillaMap<String,String> map_string = new ToatzinPadillaMap<String, String>();
		System.out.println("EMPTY: " + map_string.isEmpty());
		System.out.println("Size: " + map_string.size());
		map_string.put("1", "VAL");
		map_string.put("2", "VAL");
		map_string.put("1", "VAL");
		map_string.put("4", (String) null);
		
		System.out.println("EMPTY: " + map_string.isEmpty());
		System.out.println("Size: " + map_string.size());
		System.out.println("EL NULL: " + map_string.containsValue((String) null));
		map_string.put("1", "VAL");
		Collection<String> c = map_string.values();
		System.out.println(c);
	}

}
