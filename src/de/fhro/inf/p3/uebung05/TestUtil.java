package de.fhro.inf.p3.uebung05;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by felix on 10/30/13.
 */
public class TestUtil extends TestCase {
    private static Logger logger = Logger.getLogger(TestUtil.class.getName());

    public void testRange() {

        List<Integer> l1, l2, l3;

        l1 = Arrays.asList(0, 1, 2, 3, 4, 5);   // range: 6
        l2 = Arrays.asList();   // range: 0
        l3 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);   // range: 11

        assertEquals(Util.range(6), l1);
        assertEquals(Util.range(0), l2);
        assertEquals(Util.range(11), l3);

        try {
            Util.range(-1);
            fail();
        } catch (Exception e) {
            logger.info("Exception erkannt");
        }

        logger.info("Range Test successful!");
    }

    public void testSlice() {

        List<Integer> l1, l2, l3, l4, l5, l6;

        l1 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        l2 = Arrays.asList(0, 1, 2, 3, 4, 5);  // slice: 0-5
        l3 = Arrays.asList(6, 7, 8, 9, 10); // slice: 6-10
        l4 = Arrays.asList(3, 4, 5, 6, 7);  // slice: 3-7
        l5 = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9); // slice: 2-9
        l6 = Arrays.asList(5); // slice: 5-5

        assertEquals(Util.slice(l1, 0, 5), l2);
        assertEquals(Util.slice(l1, 6, 10), l3);
        assertEquals(Util.slice(l1, 3, 7), l4);
        assertEquals(Util.slice(l1, 2, 9), l5);
        assertEquals(Util.slice(l1, 5, 5), l6);

        try {
            Util.slice(l1, 0, 11);
            fail();
        } catch (Exception e) {
            logger.info("Exception erkannt");
        }

        try {
            Util.slice(l1, 5, 3);
            fail();
        } catch (Exception e) {
            logger.info("Exception erkannt");
        }

        try {
            Util.slice(l1, -1, 3);
            fail();
        } catch (Exception e) {
            logger.info("Exception erkannt");
        }

        logger.info("Slice Test successful!");

    }
}
