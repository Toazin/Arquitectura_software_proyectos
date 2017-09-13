package mx.jzab.edu.tdd;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Set;

/**
 *
 * @author A01630510
 */
public class VictorGarciaMapTest {
    private ToatzinPadillaMap map;
    public VictorGarciaMapTest(){
    }

    @Test
    public void testGetSize(){
    	map = new ToatzinPadillaMap();
        Assert.assertEquals(map.size(), 0,"Incorrect Size");
    }

    @Test()
    public void testGetSize_nonEmtpyMap(){
    	map = new ToatzinPadillaMap();
        map.put(1, "First value");
        map.put(2, "Second value");
        Assert.assertEquals(map.size(), 2, "Incorrect size");
    }
    @Test
    public void testclear(){
    	map = new ToatzinPadillaMap();
        map.put(1, "First value");
        map.clear();
        Assert.assertEquals(map.size(), 0, "Incorrect size");
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testRemoveEmpty() {
    	map = new ToatzinPadillaMap();
        Object result = map.remove(1);
        Assert.assertFalse(result==null, "Element removed");
    }

    @Test
    public void testRemove() {
    	map = new ToatzinPadillaMap();
        map.put(1, "first");
        boolean result = map.remove(1) != null;
        Assert.assertTrue(result, "Not removed");
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testRemoveInvalid() {
    	map = new ToatzinPadillaMap();
        boolean result = map.remove(2)==null;
    }

    @Test
    public void testGet() {
    	map = new ToatzinPadillaMap();
        map.put(1, "first");
        Assert.assertEquals(map.get(1), "first", "Not element added");
        map.put(5, "Fifth");
        Assert.assertEquals(map.get(5), "Fifth", "Not Element added");
    }
    @Test
    public void testAddElements(){
    	map = new ToatzinPadillaMap();
       for(int i=0; i<30; i++){
           map.put(i, "F "+i);
       }
       Assert.assertEquals(map.get(26), "F 26", "Got incorrect element" );
    }
    @Test
    public void testRemoveElementInBigMap(){
    	map = new ToatzinPadillaMap();
        for(int i=0; i<1000; i++){
            map.put(i, "F "+i);
        }
        map.remove(25);
        map.remove(251);
        map.remove(522);
        Assert.assertEquals(map.get(781), "F 781", "Got incorrect element" );
    }

    @Test
    public void testRemoveAndAddAgain(){
    	map = new ToatzinPadillaMap();
        for(int i=0; i<30; i++){
            map.put(1, "F "+i);
        }
        map.remove(29);
        map.remove(21);
        map.put(32, "Hey");

        Assert.assertEquals(map.get(32), "Hey", "Got incorrect element");
    }

    @Test
    public void testGetOrDefault(){
    	map = new ToatzinPadillaMap();
        Assert.assertEquals(map.getOrDefault(1, "Peine"), "Peine", "Got null element");

    }
    @Test
    public void testGetValues(){
    	map = new ToatzinPadillaMap();
        for(int i=0; i<30; i++){
            map.put(i, "F "+i);
        }
        Collection values = map.values();
        Assert.assertEquals(values.size()==30,true, "Not get the collection");
    }
    @Test
    public void testRemoveDuplicate() {
    	map = new ToatzinPadillaMap();
        map.put(1, "first");
        map.remove(1);
        boolean result = map.remove(1) == null;
        Assert.assertTrue(result, "Removed");
    }
    @Test
    public void testContainsValue() {
    	map = new ToatzinPadillaMap();
        map.put(1, "first");
        Assert.assertEquals(map.containsValue("first"),true, "Not element added");
        map.put(5, "Fifth");
        Assert.assertEquals(map.containsValue("Fifth"),true, "Not element added");
    }
    @Test
    public void testContainsKey() {
    	map = new ToatzinPadillaMap();
        map.put(3, "Third");
        Assert.assertTrue(map.containsKey(3),  "Not key added");
        map.put(9, "Nine");
        Assert.assertTrue(map.containsKey(9),  "Not key added");
    }


}

