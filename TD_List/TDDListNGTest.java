package TD_List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TDDListNGTest {
	
		private TDDList list;

		public TDDListNGTest(){
			
		}
		
		@BeforeTest
		public void before(){
			list = new TDDList();
		}
		
		@Test
		public void	 testGetSize(){
			Assert.assertEquals(list.getSize() ,0,"Incorrect size");
		}
		
		@Test
		public void testGetSize_nonEmptyList(){
			list.add("1");
			list.add("2");
			Assert.assertEquals(list.getSize(), 2, "Incorrect Size");
		}
		
		@Test
		public void testClear(){
			list.add("1");
			list.clear();
			Assert.assertEquals(list.getSize(), 0, "Incorrect Size");
		}
		
		@Test
		public void testRemoveEmpty(){
			list.add("1");
			Assert.assertTrue(list.remove(0), "Incorrect remove");
		}
		
		@Test(expectedExceptions = AssertionError.class)
		public void testRemove(){
			list.remove(-1);
//			Assertrt.assertTrue(list.remove(1), "Incorrect remove");
		}
		
		@Test
		public void testGetByIndex(){
			list.add("1");
			Assert.assertEquals(list.get(0), "1", "Incorrect value");
			list.add("2");
			Assert.assertEquals(list.get(1), "2", "Incorrect value");
		}
}
