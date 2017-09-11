package mx.jzab.edu.tdd;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TD_List.TDDList;

public class ToatzinPadillaMapTest {

	private ToatzinPadillaMap<String,String> map_string;

	public ToatzinPadillaMapTest(){
		
	}
	
//	@BeforeTest
//	public void before(){
//		map_string = new ToatzinPadillaMap<String, String>();
//	}
	
	/*
	 * Test Put
	 * void put( K key, V value )
	 */
	
	@Test
	public void	 testPut1(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		map_string.put("1","Holas");
		Assert.assertEquals(map_string.get("1"),"Holas","Put fail");
	}
	
	@Test
	public void	 testPut2(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		map_string.put("2","Holas");
		Assert.assertEquals(map_string.get("2"),"Holas","Put fail");
	}
	
	/*
	 * Clear tests
	 * void clear()
	 */
	@Test
	public void	 testClear_Full(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		map_string.put("2","Hola");
		map_string.put("3","Hola");
		map_string.clear();
		Assert.assertEquals(map_string.size(),0,"Clear fail");
	}
	
	@Test
	public void	 testClear_Empty(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.clear();
		Assert.assertEquals(map_string.size(),0,"Clear fail");
	}
	
	/*
	 * ContainsKey Test
	 * boolean containsKey( K key )
	 */
	@Test
	public void	 testContainsKey_Exists(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		Assert.assertEquals(map_string.containsKey("1"),true,"ContainsKey fail");
	}
	
	@Test
	public void	 testContainsKey_NotExists(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		Assert.assertEquals(map_string.containsKey("2"),false,"ContainsKey fail");
	}
	
	@Test
	public void	 testContainsKey_Null(){
		map_string = new ToatzinPadillaMap<String, String>();
		Assert.assertEquals(map_string.containsKey(null),false,"ContainsKey fail");
	}
	/*
	 * Contains Value Tests
	 * boolean containsValue( V value )
	 */
	@Test
	public void	 testContainsValue_Exists(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		Assert.assertEquals(map_string.containsValue("Hola"),true,"containsValue fail");
	}
	
	@Test
	public void	 testContainsValue_NotExists(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		Assert.assertEquals(map_string.containsValue("Pedro"),false,"containsValue fail");
	}
	
	@Test
	public void	 testContainsValue_Null(){
		map_string = new ToatzinPadillaMap<String, String>();
		Assert.assertEquals(map_string.containsValue(null),false,"containsValue fail");
	}
	
	/*
	 * Test GET
	 * V get( K key )
	 */
	
	@Test
	public void	 testGet_Exists(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		map_string.put("2","Hola");
		Assert.assertEquals(map_string.get("1"),"Hola","GET fail");
	}
	
	@Test
	public void	 testGet_NotExists(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		Assert.assertEquals(map_string.get("2"),null,"GET fail");
	}
	
	@Test
	public void	 testGet_Null(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1",null);
		Assert.assertEquals(map_string.get("1"),null,"GET fail");
	}
	
	/*
	 * Test Get Or Default
	 * V getOrDefault( K key, V defaultValue )
	 */
	
	@Test
	public void	 testGetOrDefault_Exists(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		map_string.put("2","Hola");
		Assert.assertEquals(map_string.getOrDefault("1","def"),"Hola","getOrDefault fail");
	}
	
	@Test
	public void	 testGetOrDefault_NotExists(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		Assert.assertEquals(map_string.getOrDefault("2","def"),"def","getOrDefault fail");
	}
	
	@Test
	public void	 testGetOrDefault_Null(){
		map_string = new ToatzinPadillaMap<String, String>();
		Assert.assertEquals(map_string.getOrDefault("2",null),null,"getOrDefault fail");
	}
	
	/*
	 * Test Is Empty
	 * isEmpty
	 */
	@Test
	public void	 testIsEmpty_Empty(){
		map_string = new ToatzinPadillaMap<String, String>();
		Assert.assertEquals(map_string.isEmpty(),true,"isEmpty fail");
	}
	
	@Test
	public void	 testIsEmpty_NonEmpty(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		Assert.assertEquals(map_string.isEmpty(),false,"isEmpty fail");
	}
	
	/*
	 * TEST Remove
	 * V remove( K key )
	 */
	
	@Test
	public void	 testRemove_Exists(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		Assert.assertEquals(map_string.remove("1"),"Hola","remove fail");
	}
	
	@Test
	public void	 testRemove_NotExists(){
		map_string = new ToatzinPadillaMap<String, String>();
		Assert.assertEquals(map_string.remove("1"),null,"remove fail");
	}
	
	/*
	 * Test Replace
	 * void replace( K key, V value ) throws NoSuchElementException
	 */
	
	@Test
	public void	 testReplace_Exists(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		map_string.replace("1","replace");
		Assert.assertEquals(map_string.get("1"),"replace","replace fail");
	}
	
	@Test(expectedExceptions = NoSuchElementException.class)
	public void	 testReplace_NotExists(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.replace("2","replace");
	}
	
	/*
	 * Test Size
	 * int size()
	 * 
	 */
	
	@Test
	public void	 testSize1(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		Assert.assertEquals(map_string.size(),1,"size fail");
	}
	
	@Test
	public void	 testSize2(){
		map_string = new ToatzinPadillaMap<String, String>();
		Assert.assertEquals(map_string.size(),0,"size fail");
	}
	
	@Test
	public void	 testSize3(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		map_string.put("2","Hola");
		map_string.put("3","Hola");
		map_string.put("1","Holas");
		Assert.assertEquals(map_string.size(),3,"size fail");
	}
	
	@Test
	public void	 testSize4(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		map_string.put("2","Hola");
		map_string.put("3","Hola");
		map_string.put("1","Holas");
		map_string.remove("1");
		Assert.assertEquals(map_string.size(),2,"size fail");
	}
	
	/*
	 * Test values
	 * Collection<V> values()
	 */
	
	@Test
	public void	 testValues_Type(){
		map_string = new ToatzinPadillaMap<String, String>();
		Collection<String> c = map_string.values();		
		Assert.assertEquals(c instanceof Collection,true,"values fail");
	}
	
	@Test
	public void	 testValues_Size(){
		map_string = new ToatzinPadillaMap<String, String>();
		map_string.put("1","Hola");
		map_string.put("2","Hola");
		Collection<String> c = map_string.values();		
		Assert.assertEquals(c.size(),2,"values fail");
	}
	
}
