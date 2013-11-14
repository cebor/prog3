package de.fhro.inf.p3.uebung07;

import junit.framework.TestCase;

/**
 * Created by felix on 11/14/13.
 */
public class TestWuseln extends TestCase {
    public void testBooelean() {
        int i = 0;

        while (i < 100) {
            System.out.println((Zufall.randomInt(0, 2) == 1));
            i++;
        }

    }
}
