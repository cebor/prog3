/*
 * Created by IntelliJ IDEA.
 * User: sid
 * Date: Feb 2, 2002
 * Time: 8:20:19 PM
 */
package de.fhro.inf.p3.uebung03;

import java.util.List;
import java.util.logging.Logger;
import junit.framework.TestCase;

public class TestGenericInterval extends TestCase {
    
	private static Logger logger =
		Logger.getLogger(TestGenericInterval.class.getName());

    private final Integer i1 = new Integer(1);
    private final Integer i2 = new Integer(2);
    private final Integer i3 = new Integer(3);
    private final Integer i4 = new Integer(4);
    private final Integer i5 = new Integer(5);
    private final Integer i6 = new Integer(6);
    private final Integer i7 = new Integer(7);
    private final Integer i8 = new Integer(8);
    private final Integer i9 = new Integer(9);
 

    public void testGenericInterval() {
    	// GenericInterval<Integer> vxx = new GenericInterval<Integer>(new Integer(2), new Double(6.0));
    	GenericInterval<Integer> v = new GenericInterval<Integer>(i3, i6);
        assertTrue(v.contains(i3));
        assertTrue(!v.contains(i6));

        List<GenericInterval<Integer>> vs = v.union(v);
        assertEquals(1, vs.size());
        assertEquals(v, vs.get(0));

        GenericInterval<Integer> w = new GenericInterval<Integer>(i7, i7);
        assertTrue(!w.contains(i4));

        vs = v.union(w);
        assertEquals(1, vs.size());
        assertEquals(v, vs.get(0));

        vs = v.union(new GenericInterval<Integer>(i7, i9));
        assertEquals(2, vs.size());
        assertEquals(v, vs.get(0));

        vs = new GenericInterval<Integer>(i7, i9).union(v);
        assertEquals(2, vs.size());
        assertEquals(v, vs.get(0));

        GenericInterval<Integer> z = new GenericInterval<Integer>(i9, i7);
        assertTrue(!z.contains(i4));

        GenericInterval<Integer> s;    // v = [3, 6)
        s = v.intersection(new GenericInterval<Integer>(i6, i8));
        assertTrue(s.isEmpty());
        s = v.intersection(new GenericInterval<Integer>(i4, i8));
        assertEquals(new GenericInterval<Integer>(i4, i6), s);

        s = v.intersection(new GenericInterval<Integer>(i4, i5));
        assertEquals(s, new GenericInterval<Integer>(i4, i5));

        s = new GenericInterval<Integer>(i6, i8).intersection(v);
        assertTrue(s.isEmpty());

        s = new GenericInterval<Integer>(i6, i8).intersection(v);

        s = new GenericInterval<Integer>(i4, i8).intersection(v);
        assertEquals(s, new GenericInterval<Integer>(i4, i6));
        s = new GenericInterval<Integer>(i4, i5).intersection(v);
        assertEquals(s, new GenericInterval<Integer>(i4, i5));
    }
    
    public void testGenericDoubleInterval() {
    	GenericInterval<Double> v = new GenericInterval<Double>(new Double(3.1),new Double(6.3));
        assertTrue(v.contains(new Double(3.1)));
        assertTrue(!v.contains(new Double(6.3)));

        List<GenericInterval<Double>> vs = v.union(new GenericInterval<Double>(new Double(7),new Double(9)));
        assertEquals(2, vs.size());
        assertEquals(v, vs.get(0));

        GenericInterval<Double> s;    // v = [3.1, 6.3)
        s = v.intersection(new GenericInterval<Double>(new Double(4), new Double(8)));
        assertEquals(new GenericInterval<Double>(new Double(4), new Double(6.3)), s);
        
    }
    
    public void testHashCode(){
        assertEquals(new GenericInterval<Integer>(i3, i6).hashCode(),
                     new GenericInterval<Integer>(i3, i6).hashCode());
        int hash1 = new GenericInterval<Integer>(i3,i4).hashCode();
        int hash2 = new GenericInterval<Integer>(i3,i4).hashCode();
        assertTrue(hash1 == hash2);
        hash2 = new GenericInterval<Integer>(i4,i5).hashCode();
        assertFalse(hash1 == hash2);
		logger.info("Test testHashCode erfolgreich!");
    }

    public void testEquals() {
    	GenericInterval<Integer> intInterval1 = new GenericInterval<Integer>(i1,i2);
       	GenericInterval<Integer> intInterval2 = new GenericInterval<Integer>(i3,i4);
    	assertTrue(intInterval1.equals(intInterval1));
    	assertFalse(intInterval1.equals(intInterval2));
    	GenericInterval<String> emptyString = new GenericInterval<String>("a","a");
    	GenericInterval<String> fullString = new GenericInterval<String>("a", "c");
    	GenericInterval<Integer> emptyInteger = new GenericInterval<Integer>(i2,i2);
    	assertTrue(emptyString.equals(emptyInteger));
    	assertFalse(fullString.equals(intInterval1));
    }

    public void testIsEmpty(){
        assertTrue(new GenericInterval<Integer>(i3,i3).isEmpty());
        assertTrue(new GenericInterval<Integer>(i4,i3).isEmpty());
        assertFalse(new GenericInterval<Integer>(i3,i4).isEmpty());
		logger.info("Test testIsEmpty erfolgreich!");
    }

    public void testContains(){
        assertTrue(new GenericInterval<Integer>(i3,i6).contains(i4));
        assertTrue(new GenericInterval<Integer>(i3,i6).contains(i4));
        assertTrue(new GenericInterval<Integer>(i3,i6).contains(i3));
        assertTrue(new GenericInterval<Integer>(i3,i6).contains(i3));
        assertFalse(new GenericInterval<Integer>(i4,i7).contains(i9));
		logger.info("Test testContains erfolgreich!");
    }
    
    public void testContainsInterval(){
    	assertTrue(new GenericInterval<Integer>(i3,i7).contains(new GenericInterval<Integer>(i4,i6)));
    	assertTrue(new GenericInterval<Integer>(i3,i7).contains(new GenericInterval<Integer>(i3,i7)));
    	assertFalse(new GenericInterval<Integer>(i3,i7).contains(new GenericInterval<Integer>(i2,i6)));
       	assertFalse(new GenericInterval<Integer>(i3,i6).contains(new GenericInterval<Integer>(i4,i7)));
    	assertFalse(new GenericInterval<Integer>(i2,i4).contains(new GenericInterval<Integer>(i5,i7)));
       	assertTrue(new GenericInterval<Integer>(i3,i7).contains(new GenericInterval<Integer>(i3,i2)));
		logger.info("Test testContainsInterval erfolgreich!");
    }
 
    public void testUnion() {
        GenericInterval<Integer> v = new GenericInterval<Integer>(i3, i6);
        GenericInterval<Integer> v2 = new GenericInterval<Integer>(i4, i7);
       
        // Vereinigung mit sich selbst
        List<GenericInterval<Integer>> vs = v.union(v);
        assertEquals(1, vs.size());
        assertEquals(v, vs.get(0));

        // Vereinigung von nicht leerem GenericInterval<Integer> mit leerem Intervall
        GenericInterval<Integer> w = new GenericInterval<Integer>(i7, i7);
        vs = v.union(w);
        assertEquals(1, vs.size());
        assertEquals(v, vs.get(0));
        
        // Vereinigung von leerem GenericInterval<Integer> mit nicht leerem Intervall
        vs = w.union(v);
        assertEquals(1, vs.size());
        assertEquals(v, vs.get(0));

        // [3,6[ vereinigt mit [7,9(
        vs = v.union(new GenericInterval<Integer>(i7, i9));
        assertEquals(2, vs.size());
        assertEquals(v, vs.get(0));

        // [7,9[ vereinigt mit [3,6(
        vs = new GenericInterval<Integer>(i7, i9).union(v);
        assertEquals(2, vs.size());
        assertEquals(v, vs.get(0));
        
        vs = v.union(new GenericInterval<Integer>(i1, i2));
        assertEquals(2, vs.size());
        assertEquals(v, vs.get(1));  
        
        // [3,6[ vereinigt mit [4,7(
        vs = v.union(v2);
        assertEquals(1, vs.size());
        assertEquals(new GenericInterval<Integer>(i3,i7), vs.get(0)); 
        // [4,7[ vereinigt mit [3,6(
        vs = v2.union(v);
        assertEquals(1, vs.size());
        assertEquals(new GenericInterval<Integer>(i3,i7), vs.get(0));  
        
        logger.info("Test testUnion erfolgreich!");
    }


}
