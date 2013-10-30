package de.fhro.inf.p3.uebung04;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by felix on 10/24/13.
 *
 * JUnit
 */
public class TestUtil extends TestCase {

    private final int N = 100;

    private static Logger logger = Logger.getLogger(TestUtil.class.getName());

    public void testReverse2() {

        List<Integer> l1, l2, l3;

        l1 = new ArrayList<Integer>();
        l2 = new ArrayList<Integer>();
        l3 = new ArrayList<Integer>();

        for (int i = 0, j = N - 1; i < N && j >= 0; i++, j--) {
            l1.add(i);
            l2.add(j);
        }

        assertTrue(l1.equals(Util.<Integer>reverse2(l2)));
    }
}
