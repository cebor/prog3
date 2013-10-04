package de.fhro.inf.p3.uebung01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import junit.framework.TestCase;

/**
 * User: sid
 * Date: 03.03.2005
 * Time: 15:01:32
 * User: Hue
 * Date: 04.10.05
 * weitere Testfälle eingefügt
 */
public class TestRoList extends TestCase {
    private static final long N = 5000; //50000;
    private static final int M = 100;

    //	Initialisierung Logger
    private static Logger logger = Logger.getLogger(TestRoList.class.getName());

    public void testMake() {
        RoList xs = new RoList();
        assertTrue(xs.size() == 0);

        xs.add("aa");
        xs.add("bb");
        xs.add("cc");
        assertTrue(xs.size() == 3);

        // Kopiert Liste xs nach ys
        RoList ys = new RoList(xs);
        assertTrue(ys.size() == 3);
        assertEquals(xs, ys);
        ys.add("dd");
        assertTrue(xs.size() != ys.size());
        assertEquals(ys.get(3), "dd");
        try {
            // alte Liste bleibt unverändert
            xs.get(3);
            fail();
        } catch (Exception e) {
            logger.info("Exception erkannt");
        }
        xs.clear();
        assertTrue(xs.size() == 0);
    }

    public void testAddRemove() {
        RoList xs = new RoList();
        RoList ys = new RoList();
        ArrayList as = new ArrayList();

        for (int i = 0; i < N; i++) {
            xs.add(new Integer(i));
            as.add(new Integer(i));
        }
        assertTrue(xs.size() == N);

        ys.addAll(as);
        assertEquals(xs, ys);

        for (int i = 0; i < N; i++) {
            xs.remove(new Integer(i));
        }
        assertTrue(xs.size() == 0);

        ys.removeAll(as);
        assertTrue(ys.size() == 0);
    }

    public void testIterator() {
        RoList xs = new RoList();
        for (int i = 1; i < N+1; i++) {
            xs.add(new Integer(i));
        }
        assertTrue(xs.size() == N);

        Iterator i = xs.iterator();
        int sum = 0;
        while (i.hasNext()) {
            Integer n = (Integer) i.next();
            sum += n.intValue();
        }
        assertTrue(sum == (N - 1) * N / 2 + N);
        
    }

    public void testEquals() {
        RoList xs = new RoList();
        for (int i = 0; i < N; i++) {
            xs.add(new Integer(i));
        }

        RoList ys = (RoList) xs.clone();
        assertEquals(xs, ys);
        assertEquals(xs.hashCode(), ys.hashCode());

        xs.set(0, new Integer(1));
        assertFalse(xs.equals(ys));

    }

    public void testGetSetIndexContains() {
        RoList xs = new RoList();

        for (int i = 0; i < M; i++) {
            xs.add(new Integer(i));
        }
        assertTrue(xs.size() == M);

        for (int i = 0; i < M; i++) {
            assertTrue(i == xs.indexOf(new Integer(i)));
            assertTrue(xs.contains(new Integer(i)));
        }
        assertFalse(xs.contains(new Integer(M + 1)));
        assertTrue(-1 == xs.indexOf(new Integer(M + 1)));
        logger.info("Test beendet");
    }
}
